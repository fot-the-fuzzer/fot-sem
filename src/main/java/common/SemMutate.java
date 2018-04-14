package common;

import css.parser.CSSFotParser;
import js.parser.JSFotParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xml.parser.XMLFotParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * this corresponding to ONE file to be mutated
 */
public class SemMutate {

    private static Logger logger = LoggerFactory.getLogger(SemMutate.class);

    private String fileName;
    private String label;
    private String content;
    private FotParser wrapper;
    private Mutator mutator;
    @SuppressWarnings("FieldCanBeLocal")
    private NodeKeeper keeper;

    private static Map<String, FotParser> wrappers = new HashMap<>();

    public String getLabel() {
        return label;
    }

    public String getFileName() {
        return fileName;
    }

    static {
        wrappers.put("js", new JSFotParser());
        wrappers.put("xml", new XMLFotParser());
        wrappers.put("css", new CSSFotParser());
    }

    public static void populateWrappers(Map<String, FotParser> map) {
        for (Map.Entry<String, FotParser> entry : map.entrySet()) {
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

    private static String readFileToString(File inFile) {
        Path path = inFile.toPath();
        String content = null;
        try {
            byte[] bytes = Files.readAllBytes(path);
            content = new String(bytes);
        } catch (IOException e) {
            logger.error(e.getMessage());
            System.exit(1);
        }
        return content;
    }

    private FotParser initWrapper(String ext) throws ParserNotFoundException {
        FotParser wrapper = null;
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

    private static CharStream getStreamFromStr(String buf) {
        return CharStreams.fromString(buf);
    }

    public SemMutate(File file, String ext) throws ParserNotFoundException {
        this.wrapper = initWrapper(ext);
        this.mutator = new Mutator();
        this.fileName = Utils.getFileName(file);
        this.label = Utils.getLabelFromFileName(file);
        this.content = readFileToString(file);
        // leave keeper null
    }

    public String mutate(MutEnum mutEnum) {
        CharStream stream = null;
        stream = getStreamFromStr(this.content);
        try {
            this.wrapper.init(stream);
            this.keeper = this.wrapper.collect(this.wrapper.getParseRuleContext());
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
            e.setSource(this.fileName);
            throw e;
        }
    }

}
