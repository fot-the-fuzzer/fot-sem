package common;

import css.parser.CSSWrapper;
import js.parser.JSWrapper;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStreamRewriter;
import xml.parser.XMLWrapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SemMutate {

    public static String run(String buf, String ext) throws ParserNotFoundException {
        List<MutEnum> muts = new ArrayList<>();
        muts.add(MutEnum.INS);
        muts.add(MutEnum.DEL);
        muts.add(MutEnum.REP);
        CharStream stream = getStreamFromStr(buf);
        String out = null;
        for (MutEnum mut : muts) {
            SemMutate semMutate = new SemMutate(buf, ext);
            out = semMutate.mutate(mut);
        }
        return out;
    }

    private String label;
    private String content;
    private ParserWrapper wrapper;
    private Mutator mutator;
    @SuppressWarnings("FieldCanBeLocal")
    private NodeKeeper keeper;

    private static Map<String, ParserWrapper> wrappers = new HashMap<>();

    static {
        wrappers.put("js", new JSWrapper());
        wrappers.put("xml", new XMLWrapper());
        wrappers.put("css", new CSSWrapper());
    }

    public static void populateWrappers(Map<String, ParserWrapper> map) {
        for (Map.Entry<String, ParserWrapper> entry : map.entrySet()) {
            wrappers.put(entry.getKey(), entry.getValue());
        }
    }

    @SuppressWarnings("WeakerAccess")
    public static CharStream getStreamFromFile(File file) throws IOException {
        FileReader reader = new FileReader(file);
        return CharStreams.fromReader(reader);
    }

    public static CharStream getStreamFromFile(String fileName) throws IOException {
        return getStreamFromFile(new File(fileName));
    }

    public static String readFileToString(File inFile) {
        Path path = inFile.toPath();
        String content = null;
        try {
            byte[] bytes = Files.readAllBytes(path);
            content = new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return content;
    }

    private ParserWrapper initWrapper(String ext) throws ParserNotFoundException {
        ParserWrapper wrapper = null;
        if (ext == null) {
            throw new ParserNotFoundException("NULL");
        } else {
            wrapper = wrappers.get(ext);
            if (wrapper == null) {
                throw new ParserNotFoundException(ext);
            }
        }
        return wrapper;
    }

    public static CharStream getStreamFromStr(String buf) {
        return CharStreams.fromString(buf);
    }

    public SemMutate(String buf, String ext) throws ParserNotFoundException {
        this.wrapper = initWrapper(ext);
        this.mutator = new Mutator();
        this.label = "[buf]";
        this.content = buf;
        // leave keeper null
    }

    public SemMutate(File file, String ext) throws ParserNotFoundException {
        this.wrapper = initWrapper(ext);
        this.mutator = new Mutator();
        this.label = file.getAbsolutePath();
        this.content = readFileToString(file);
        // leave keeper null
    }

    public String mutate(MutEnum mutEnum) {
        CharStream stream = null;
        stream = getStreamFromStr(this.content);
        try {
            this.wrapper.init(stream);
            this.keeper = this.wrapper.collect(this.wrapper.getContext());
            TokenStreamRewriter rewriter = this.wrapper.getRewriter();
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
        } catch (ParseErrorException e) {
            System.err.printf("Error when parsing %s with %s\ncause: %s\n", this.label, this.wrapper, e.getMessage());
            System.exit(1);
            return "";
        }
    }

}
