package js.parser;

import common.Utils;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public final class ParserWrapper {

    private ECMAScriptLexer lexer;
    private CommonTokenStream tokenStream;
    private ECMAScriptParser parser;

    public ECMAScriptLexer getLexer() {
        return lexer;
    }

    public ECMAScriptParser getParser() {
        return this.parser;
    }

    public CommonTokenStream getTokenStream() {
        return this.tokenStream;
    }

    public ParserWrapper(CharStream input) {
        this.lexer = new ECMAScriptLexer(input);
        this.lexer.removeErrorListeners();
        this.lexer.addErrorListener(Utils.LISTENER);

        this.tokenStream = new CommonTokenStream(this.lexer);

        this.parser = new ECMAScriptParser(this.tokenStream);
        this.parser.removeErrorListeners();
        this.parser.addErrorListener(Utils.LISTENER);
    }

    ParserWrapper(ECMAScriptLexer lexer) {
        this.lexer = lexer;

        this.tokenStream = new CommonTokenStream(lexer);

        this.parser = new ECMAScriptParser(this.tokenStream);
        this.parser.removeErrorListeners();
        this.parser.addErrorListener(Utils.LISTENER);
    }

    public ParserWrapper withErrorListener(ANTLRErrorListener listener) {
        this.parser.removeErrorListeners();
        this.parser.addErrorListener(listener);
        return this;
    }
}
