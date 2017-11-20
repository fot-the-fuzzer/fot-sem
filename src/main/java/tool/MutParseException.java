package tool;

final class MutParseException extends Exception {
    public MutParseException(String msg, CLIOptions opt) {
        super(String.format("%s\n%s", msg, opt));
    }
}
