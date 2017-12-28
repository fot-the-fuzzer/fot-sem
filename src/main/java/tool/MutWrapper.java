package tool;

/**
 * this is the FFI, change with care
 */
public class MutWrapper {

    public static void run(String inFile, String outDir, String ext, long iterations, long start) {
        CLIOptions cliOptions = new CLIOptions(inFile, outDir, ext, iterations, start);
        MutGen gen = null;
        try {
            gen = new MutGen(cliOptions);
            gen.run();
        } catch (MutParseException e) {
            e.printStackTrace();
        }
    }

}
