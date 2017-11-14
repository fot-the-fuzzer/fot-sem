package common;

public class ParseErrorException extends RuntimeException {
    ParseErrorException(String msg) {
        super(msg);
    }
}
