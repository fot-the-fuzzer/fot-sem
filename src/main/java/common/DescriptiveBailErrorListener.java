package common;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * An error listener that immediately bails out of the parse (does not recover)
 * and throws a runtime exception with a descriptive error message.
 */
public class DescriptiveBailErrorListener extends BaseErrorListener {

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e) {
        throw new ParseErrorException(recognizer.getInputStream().getSourceName(), line, charPositionInLine, msg);
    }
}
