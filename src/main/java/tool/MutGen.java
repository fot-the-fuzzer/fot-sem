package tool;

import common.FileDelVisitor;
import common.Utils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;

public class MutGen {

    public static Logger logger = LoggerFactory.getLogger(MutGen.class);

    private String prefix;
    private String ext;
    private boolean fromDir;
    private File inputFile;
    private File outputFile;
    private long iterations;
    private HashSet<String> generated;
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
        if (outFile.exists()) {
            logger.warn("removing existing out file: {}", outFile);
            Path path = outFile.toPath();
            try {
                if (outFile.isDirectory()) {
                    Files.walkFileTree(path, new FileDelVisitor());
                } else {
                    Files.delete(path);
                }
            } catch (IOException e) {
                e.printStackTrace(System.err);
                System.exit(1);
            }
        }
        boolean succeed = outFile.mkdirs();
        if (!succeed) {
            throw new MutParseException("failed to create output directory", opt);
        }
        this.outputFile = outFile;
        if (opt.prefix == null) {
            this.prefix = "";
        } else {
            this.prefix = opt.prefix;
        }
        this.generated = new HashSet<>();
        this.counter = 0;
    }

    private void collectNew() {

    }

    // TODO
    @NotNull
    private String mutateImpl() {
        return null;
    }

    private void dumpToFile(String content) {
        String fileName;
        if (this.prefix.equals("")) {
            fileName = String.format("%s.%s", this.counter, this.ext);
        } else {
            fileName = String.format("%s-%s.%s", this.prefix, this.counter, this.ext);
        }
        Path outPath = Paths.get(this.outputFile.getPath(), fileName);
        OutputStream os = null;
        try {
            os = new FileOutputStream(outPath.toString());
            PrintStream out = new PrintStream(os);
            out.println(content);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    private void mutate() {
        String mutatedText = mutateImpl();
        String md5 = Utils.getMD5(mutatedText);
        if (!this.generated.contains(md5)) {
            dumpToFile(mutatedText);
        }
    }

    public void run() {
        while (this.counter != this.iterations) {
            this.counter += 1;
            if (this.fromDir) {
                collectNew();
            }
            mutate();
        }
    }

}
