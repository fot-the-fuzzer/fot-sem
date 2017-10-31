package common;

import js.parser.JSWrapper;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStreamRewriter;
import xml.parser.XMLWrapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SemMutate {

    private File file;
    private ParserWrapper wrapper;
    private Mutator mutator;
    private NodeKeeper keeper;

    private static Map<String, ParserWrapper> wrappers = new HashMap<>();

    static {
        wrappers.put("js", new JSWrapper());
        wrappers.put("xml", new XMLWrapper());
    }

    public static void populateWrappers(Map<String, ParserWrapper> map) {
        for (Map.Entry<String, ParserWrapper> entry : map.entrySet()) {
            wrappers.put(entry.getKey(), entry.getValue());
        }
    }

    public static CharStream getStreamFromFile(File file) throws IOException {
        FileReader reader = new FileReader(file);
        return CharStreams.fromReader(reader);
    }

    public static CharStream getStreamFromFile(String fileName) throws IOException {
        return getStreamFromFile(new File(fileName));
    }

    public SemMutate(File file) {
        this.file = file;
        String fileName = file.getName();
        int idx = fileName.lastIndexOf('.');
        if (idx > 0) {
            String ext = fileName.substring(idx + 1).toLowerCase();
            this.wrapper = wrappers.get(ext);
        } else {
            System.err.printf("unknown file extension: %s\n", fileName);
            System.exit(1);
        }
        this.mutator = new Mutator();
        // leave keeper null
    }

    public SemMutate(File file, ParserWrapper wrapper) {
        this.file = file;
        this.wrapper = wrapper;
        this.mutator = new Mutator();
        // leave keeper null
    }

    public String mutate(MutEnum mutEnum) {
        CharStream stream = null;
        try {
            stream = getStreamFromFile(this.file);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        this.wrapper.init(stream);
        this.keeper = wrapper.collect(wrapper.getContext());
        TokenStreamRewriter rewriter = wrapper.getRewriter();
        switch (mutEnum) {
            case INS:
                return this.mutator.insert(rewriter, this.keeper);
            case DEL:
                return this.mutator.delete(rewriter, this.keeper);
            case REP:
                return this.mutator.replace(rewriter, this.keeper);
            case RAND:
            default:
                return this.mutator.random(rewriter, this.keeper);
        }
    }

}
