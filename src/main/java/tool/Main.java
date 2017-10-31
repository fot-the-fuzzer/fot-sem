package tool;

import common.Mutation;
import common.Mutator;
import js.parser.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import picocli.CommandLine;
import xml.parser.XMLMutator;

import java.io.*;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    static Map<String, Mutator> mutators;

    public static CharStream getStreamFromFile(File file) throws IOException {
        FileReader reader = new FileReader(file);
        return CharStreams.fromReader(reader);
    }

    public static CharStream getStreamFromFile(String fileName) throws IOException {
        return getStreamFromFile(new File(fileName));
    }

    public static void visitDemo(File fileName) {
        CharStream stream = null;
        try {
            stream = getStreamFromFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        ParserWrapper wrapper = new ParserWrapper(stream);
        ECMAScriptParser parser = wrapper.getParser();
        NodeCollector collector = new NodeCollector();
        ParserRuleContext context = parser.program();
        collector.visit(context);

        Map<Interval, String> map = collector.getMap();
        NodeKeeper keeper = new NodeKeeper(map);
        System.out.println(keeper);

        CommonTokenStream tokenStream = wrapper.getTokenStream();

        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        int index = rnd.nextInt(keeper.size());
        TokenStreamRewriter rewriter = new TokenStreamRewriter(tokenStream);
        JSNode node = keeper.get(index);
        Interval interval = node.getInterval();
        System.out.println("interval: " + interval);

        System.out.println("\nbefore:\n" + rewriter.getText());
        rewriter.delete(interval.a, interval.b);
        System.out.println("\nafter:\n" + rewriter.getText());

        {
            int i1 = rnd.nextInt(keeper.size());
            int i2 = rnd.nextInt(keeper.size());
            JSNode node1 = keeper.get(i1);
            JSNode node2 = keeper.get(i2);
            rewriter.replace(interval.a, interval.b, node2.getText());
            System.out.println("\nfinal:\n" + rewriter.getText());
        }

    }

    public static void mutate(File inFile, Mutation mutation, PrintStream outStream) throws Exception {
        String fileName = inFile.getName();
        CharStream charStream = getStreamFromFile(inFile);
        int idx = fileName.lastIndexOf('.');
        if (idx > 0) {
            String ext = fileName.substring(idx + 1).toLowerCase();
            Mutator mutator = mutators.get(ext);
            String mutatedText = null;
            switch (mutation) {
                case INS:
                    mutatedText = mutator.insert(charStream);
                    break;
                case DEL:
                    mutatedText = mutator.delete(charStream);
                    break;
                case REP:
                    mutatedText = mutator.replace(charStream);
                    break;
                case RAND:
                default:
                    Random random = new Random();
                    int res = random.nextInt(3);
                    switch (res) {
                        case 0:
                            mutatedText = mutator.insert(charStream);
                            break;
                        case 1:
                            mutatedText = mutator.delete(charStream);
                            break;
                        case 2:
                            mutatedText = mutator.replace(charStream);
                            break;
                    }
            }
            outStream.println(mutatedText);
        } else {
            throw new Exception("Unknown file extension");
        }
    }

    public static void main(String[] args) {

        mutators.put("js", new JSMutator());
        mutators.put("xml", new XMLMutator());

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
                visitDemo(options.inputFile);
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
            e.printStackTrace();
            System.exit(1);
        }
    }
}
