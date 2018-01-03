package tool;

import common.MutEnum;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;

import java.io.File;

@Command(name = "fot-sem",
        showDefaultValues = true,
        version = "0.0.1",
        header = "FOT Semantic Fuzzing CLI tool",
        description = "This is a wrapper for a jar runnable, which can also be used as a library/FFI.\n\n")
public class CLIOptions {

    public static String PREFIX = "gen";

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Display this help message and exit")
    private boolean helpRequested = false;

    @Option(names = {"-v", "--version"}, versionHelp = true, description = "Display version info and exit")
    private boolean versionHelp = false;

    @Option(names = {"-i", "--in"}, paramLabel = "FILE", description = "input file/directory")
    public File inputFile;

    @Option(names = {"-o", "--out"}, paramLabel = "FILE", description = "output file/directory, default to stdout")
    public String out;

    @Option(names = {"-e", "--ext"}, paramLabel = "EXT", description = "file extension of the input files (when not specified, will infer from file name)")
    public String ext;

    @Option(names = {"-p", "--prefix"}, description = "out files' name prefix (when output is a directory, used to avoid name clashes)")
    public String prefix = PREFIX;

    @Option(names = {"-s", "--start"}, description = "starting index")
    public long start = 0;

    /**
     * for dumper
     */
    @Option(names = {"-m", "--mutEnum"}, description = "mutEnum that will be applied")
    public MutEnum mutEnum = MutEnum.RAND;

    /**
     * for generator
     */
    @Option(names = {"-n", "--num"}, description = "numbers of iterations to be generated, infinite when value <0")
    public long iterations = -1;

    public CLIOptions() {
    }

    public CLIOptions(String inFile, String outDir, String ext, long iterations, long start) {
        this.start = start;
        this.iterations = iterations;
        this.helpRequested = false;
        this.versionHelp = false;
        this.inputFile = new File(inFile);
        this.out = outDir;
        this.ext = ext;
        this.prefix = PREFIX;
        this.mutEnum = MutEnum.RAND;
    }

    @Override
    public String toString() {
        return "CLIOptions{" +
                "inputFile=" + inputFile +
                ", out='" + out + '\'' +
                ", ext='" + ext + '\'' +
                ", prefix='" + prefix + '\'' +
                ", mutEnum=" + mutEnum +
                ", iterations=" + iterations +
                '}';
    }
}
