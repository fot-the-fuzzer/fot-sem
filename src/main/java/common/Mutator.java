package common;

import org.antlr.v4.runtime.CharStream;

public interface Mutator {
    String insert(CharStream stream);

    String delete(CharStream stream);

    String replace(CharStream stream);
}
