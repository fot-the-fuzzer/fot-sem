package js.parser;

import common.ListenerUtils;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStream;

public final class JSLexerWrapper {

    private ECMAScriptLexer lexer;

    @SuppressWarnings("WeakerAccess")
    public JSLexerWrapper(CharStream input) {
        this.lexer = new ECMAScriptLexer(input);
        ListenerUtils.withDefaultListener(this.lexer);
    }

    public JSLexerWrapper withStrictMode(boolean strictMode) {
        this.lexer.setStrictMode(strictMode);
        return this;
    }

    public JSLexerWrapper withErrorListener(ANTLRErrorListener listener) {
        ListenerUtils.withListener(this.lexer, listener);
        return this;
    }

    public ECMAScriptLexer build() {
        return this.lexer;
    }
}
