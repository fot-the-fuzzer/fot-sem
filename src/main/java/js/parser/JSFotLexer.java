package js.parser;

import common.ListenerUtils;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStream;

public final class JSFotLexer {

    private ECMAScriptLexer lexer;

    @SuppressWarnings("WeakerAccess")
    public JSFotLexer(CharStream input) {
        this.lexer = new ECMAScriptLexer(input);
        ListenerUtils.withDefaultListener(this.lexer);
    }

    public JSFotLexer withStrictMode(boolean strictMode) {
        this.lexer.setStrictMode(strictMode);
        return this;
    }

    public JSFotLexer withErrorListener(ANTLRErrorListener listener) {
        ListenerUtils.withListener(this.lexer, listener);
        return this;
    }

    public ECMAScriptLexer build() {
        return this.lexer;
    }
}
