package js.parser;

import common.Utils;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

public final class LexerWrapper {

    private ECMAScriptLexer lexer;

    @SuppressWarnings("WeakerAccess")
    public LexerWrapper(CharStream input) {
        this.lexer = new ECMAScriptLexer(input);
        this.lexer.removeErrorListeners();
        this.lexer.addErrorListener(Utils.LISTENER);
    }

    public LexerWrapper withStrictMode(boolean strictMode) {
        this.lexer.setStrictMode(strictMode);
        return this;
    }

    /**
     * specify the required listener
     * @param listener
     * @return
     */
    public LexerWrapper withErrorListener(ANTLRErrorListener listener) {
        this.lexer.removeErrorListeners();
        this.lexer.addErrorListener(listener);
        return this;
    }

    public ECMAScriptLexer build() {
        return this.lexer;
    }
}
