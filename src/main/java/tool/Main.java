package tool;

import picocli.CommandLine;


public class Main {

    public static void main(String[] args) {

        CLIOptions options = new CLIOptions();
        CommandLine cli = new CommandLine(options);
        if (args.length == 0) {
            cli.usage(System.err);
            System.exit(1);
        }
        try {
            cli.parse(args);
            if (cli.isUsageHelpRequested()) {
                cli.usage(System.out);
                System.exit(0);
            }
            if (cli.isVersionHelpRequested()) {
                cli.printVersionHelp(System.out);
                System.exit(0);
            }
            if (options.inputFile == null) {
                System.err.println("input file not specified");
                cli.usage(System.err);
                System.exit(1);
            }

            if (options.out == null) {
                MutDumper dumper = new MutDumper(options);
                dumper.run();
            } else {
                MutGen driver = new MutGen(options);
                driver.run();
            }
        } catch (CommandLine.ParameterException | MutParseException e) {
            System.err.println(e.getMessage());
            cli.usage(System.err);
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
