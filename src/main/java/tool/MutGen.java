package tool;

import common.*;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MutGen {

    private static Logger logger = LoggerFactory.getLogger(MutGen.class);

    private String prefix;
    private String ext;
    private boolean fromDir;
    private File inputFile;
    private File outputFile;
    private long iterations;
    private HashSet<String> generatedMd5;
    private List<SemMutate> semMutates;
    private long counter;

    private static String inferExt(File file) {
        String fileName = file.getName();
        int idx = fileName.lastIndexOf('.');
        if (idx > 0) {
            return fileName.substring(idx + 1).toLowerCase();
        } else {
            return null;
        }
    }

    MutGen(CLIOptions opt) throws MutParseException {
        this.iterations = opt.iterations;
        this.inputFile = opt.inputFile;
        if (opt.inputFile.isDirectory()) {
            this.fromDir = true;
            if (opt.ext != null) {
                this.ext = opt.ext;
            } else {
                throw new MutParseException("when input is a directory, file extension should be specified", opt);
            }
        } else {
            this.fromDir = false;
            if (opt.ext != null) {
                this.ext = opt.ext;
            } else {
                this.ext = inferExt(this.inputFile);
            }
        }
        File outFile = new File(opt.out);
        if (!outFile.exists()) {
            boolean succeed = outFile.mkdirs();
            if (!succeed) {
                throw new MutParseException("failed to create output directory", opt);
            }
        }
        this.outputFile = outFile;
        if (opt.prefix == null) {
            this.prefix = "";
        } else {
            this.prefix = opt.prefix;
        }
        this.generatedMd5 = new HashSet<>();
        this.counter = 0;
        this.semMutates = new ArrayList<>();
    }

    private void initSeeds() {
        if (this.fromDir) {
            File backupDir = new File(this.inputFile, "backup");
            if (!backupDir.exists()) {
                boolean success = backupDir.mkdirs();
                if (!success) {
                    logger.error("cannot create directory: {}", backupDir);
                    System.exit(1);
                }
            }
            // rename files
            File[] inputFiles = this.inputFile.listFiles();
            if (inputFiles != null) {
                for (File srcFile : inputFiles) {
                    if (srcFile.isFile()) {
                        File dstFile = new File(backupDir, srcFile.getName());
                        boolean success = srcFile.renameTo(dstFile);
                        if (!success) {
                            logger.error("cannot rename {} to {}", srcFile, dstFile);
                            System.exit(1);
                        }
                        try {
                            logger.info("new seed: {}", dstFile);
                            SemMutate semMutate = new SemMutate(dstFile, this.ext);
                            this.semMutates.add(semMutate);
                        } catch (ParserNotFoundException e) {
                            logger.error(e.getMessage());
                            System.exit(1);
                        }
                    }
                }
            }
            // backup files into sem
            File[] bakFiles = backupDir.listFiles();
            if (bakFiles != null) {
                for (File bakFile : bakFiles) {
                    if (bakFile.isFile()) {
                        addToSem(bakFile);
                    }
                }
            }
        } else {
            addToSem(this.inputFile);
        }
    }

    private void addToSem(File file) {
        logger.info("new seed: {}", file);
        try {
            SemMutate semMutate = new SemMutate(file, this.ext);
            this.semMutates.add(semMutate);
        } catch (ParserNotFoundException e) {
            logger.error(e.getMessage());
            System.exit(1);
        }
    }

    private void collectNewSeeds() {
        assert this.inputFile.isDirectory();
        File[] inFiles = this.inputFile.listFiles();
        File backupDir = new File(this.inputFile, "backup");
        if (inFiles != null) {
            for (File srcFile : inFiles) {
                if (srcFile.isFile()) {
                    File dstFile = new File(backupDir, srcFile.getName());
                    boolean success = srcFile.renameTo(dstFile);
                    if (!success) {
                        logger.error("failed to rename {} to {}", srcFile, dstFile);
                        System.exit(1);
                    }
                    addToSem(dstFile);
                }
            }
        }
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    @NotNull
    private String mutateImpl(SemMutate semMutate) {
        String mutated = semMutate.mutate(MutEnum.RAND);
        return mutated;
    }

    private void dumpToFile(String content, String label) {
        String fileName;
        if (this.prefix.equals("")) {
            fileName = String.format("%s-%08d.%s", label, this.counter, this.ext);
        } else {
            fileName = String.format("%s-%s-%08d.%s", this.prefix, label, this.counter, this.ext);
        }
        Path outPath = Paths.get(this.outputFile.getPath(), fileName);
        OutputStream os = null;
        try {
            os = new FileOutputStream(outPath.toString());
            PrintStream out = new PrintStream(os);
            out.println(content);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            System.exit(1);
        }
    }

    private void mutate() {
        Iterator<SemMutate> iterator = this.semMutates.iterator();
        while (iterator.hasNext()) {
            SemMutate semMutate = iterator.next();
            String label = semMutate.getLabel();
            logger.info("round {} on {}", this.counter, label);
            try {
                String mutatedText = mutateImpl(semMutate);
                String md5 = Utils.getMD5(mutatedText);
                if (!this.generatedMd5.contains(md5)) {
                    dumpToFile(mutatedText, label);
                }
            } catch (ParseErrorException e) {
                logger.warn("parsing error, source: {}, line: {}, column: {}, removing...\nmessage: {}\n", e.getSource(), e.getRow(), e.getColumn(), e.getMessage());
                iterator.remove();
            }
        }
    }

    public void run() {
        initSeeds();
        while (this.counter != this.iterations) {
            this.counter += 1;
            if (this.fromDir) {
                collectNewSeeds();
            }
            mutate();
        }
    }

}
