package tool;

/**
 * this is the FFI, change with care
 */
public class MutWrapper {

    // TODO keep track of failed mutations
    public static int run(String inFile, String outDir, String ext, long iterations, long start) {
        CLIOptions cliOptions = new CLIOptions(inFile, outDir, ext, iterations, start);
        MutGen gen = null;
        try {
            gen = new MutGen(cliOptions);
            int generated = gen.run();
            return generated;
        } catch (MutParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
