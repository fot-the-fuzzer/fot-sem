package tool;

import common.Mutation;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import java.io.File;

@CommandLine.Command(showDefaultValues = true)
public class CLIOptions {
    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Display this help message and exit")
    private boolean helpRequested = false;

    @Option(names = {"-i", "--in"}, paramLabel = "FILE", description = "input file")
    public File inputFile;

    @Option(names = {"-v", "--version"}, versionHelp = true, description = "Display version info and exit")
    private boolean versionHelp = false;

    @Option(names = {"-o", "--out"}, paramLabel = "FILE", description = "output file")
    public String outFile;

    @Option(names = {"-m", "--mutation"}, description = "mutation that will be applied")
    public Mutation mutation = Mutation.RAND;

}
