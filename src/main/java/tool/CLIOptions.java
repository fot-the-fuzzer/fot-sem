package tool;

import common.MutEnum;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import java.io.File;

@CommandLine.Command(showDefaultValues = true)
public class CLIOptions {
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Display this help message and exit")
    private boolean helpRequested = false;

    @Option(names = {"-i", "--in"}, paramLabel = "FILE", description = "input file")
    public File inputFile;

    @Option(names = {"-p", "--parser"}, paramLabel = "EXT", description = "file extension (corresponding to parser)")
    public String ext;

    @Option(names = {"-v", "--version"}, versionHelp = true, description = "Display version info and exit")
    private boolean versionHelp = false;

    @Option(names = {"-o", "--out"}, paramLabel = "FILE", description = "output file")
    public String outFile;

    @Option(names = {"-m", "--mutEnum"}, description = "mutEnum that will be applied")
    public MutEnum mutEnum = MutEnum.RAND;

}
