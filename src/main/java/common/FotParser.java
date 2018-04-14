package common;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStreamRewriter;

// the parser wrapper interface
public interface FotParser {

    ParserRuleContext getParseRuleContext();

    TokenStreamRewriter getRewriter();

    void init(CharStream charStream);

    NodeKeeper collect(ParserRuleContext context);

}
