package tool;

import js.parser.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import picocli.CommandLine;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static CharStream getStreamFromFile(File file) throws IOException, URISyntaxException {
        FileReader reader = new FileReader(file);
        return CharStreams.fromReader(reader);
    }

    public static CharStream getStreamFromFile(String file) throws IOException, URISyntaxException {
        return getStreamFromFile(new File(file));
    }

    private static void dumpParserTreeDemo(File file) {

        CharStream stream = null;
        try {
            stream = getStreamFromFile("js/simple.js");
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            System.exit(1);
        }

        String s = ParserTreeDumper.toStringASCII(stream);
        System.out.println(s);

    }

    public static void visitDemo(File fileName) {
        CharStream stream = null;
        try {
            stream = getStreamFromFile(fileName);
        } catch (IOException | URISyntaxException e) {
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

    public static void main(String[] args) {
        CLIOptions options = new CLIOptions();
        CommandLine cli = new CommandLine(options);
        cli.parse(args);
        if (args.length == 0) {
            cli.usage(System.err);
            System.exit(1);
        }
        if (cli.isUsageHelpRequested()) {
            cli.usage(System.out);
            System.exit(0);
        }
        if (cli.isVersionHelpRequested()) {
            cli.printVersionHelp(System.out);
            System.exit(0);
        }
        if (options.inputFile != null) {
            visitDemo(options.inputFile);
        }
    }
}
