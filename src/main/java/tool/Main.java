package tool;

import common.*;
import picocli.CommandLine;
import common.SemMutate;

import java.io.*;

public class Main {

    private static void mutate(File inFile, MutEnum mutEnum, PrintStream outStream) {
        String name = inFile.getAbsolutePath();
        SemMutate semMutate = new SemMutate(inFile);
        String mutatedText = semMutate.mutate(mutEnum);
        outStream.println(mutatedText);
    }

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

            PrintStream printStream;
            if (options.outFile == null) {
                printStream = System.out;
            } else {
                File outFile = new File(options.outFile);
                FileOutputStream fos = new FileOutputStream(outFile, false);
                printStream = new PrintStream(fos);
            }
            if (options.inputFile != null) {
                mutate(options.inputFile, options.mutEnum, printStream);
            } else {
                System.err.println("input file not specified");
                cli.usage(System.err);
                System.exit(1);
            }
        } catch (CommandLine.ParameterException e) {
            System.err.println(e.getMessage());
            e.getCommandLine().usage(System.err);
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
