package common;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;

public final class ListenerUtils {

    private static final DescriptiveBailErrorListener LISTENER = new DescriptiveBailErrorListener();

    public static void withDefaultListener(Parser parser) {
        parser.removeErrorListeners();
        parser.addErrorListener(LISTENER);
    }

    public static void withDefaultListener(Lexer lexer) {
        lexer.removeErrorListeners();
        lexer.addErrorListener(LISTENER);
    }

    public static void withListener(Parser parser, ANTLRErrorListener listener) {
        parser.removeErrorListeners();
        parser.addErrorListener(listener);
    }

    public static void withListener(Lexer lexer, ANTLRErrorListener listener) {
        lexer.removeErrorListeners();
        lexer.addErrorListener(listener);
    }

}
