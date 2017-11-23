package common;

public class ParseErrorException extends RuntimeException {

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {

        return source;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    private String source;
    private int row;
    private int column;

    ParseErrorException(String source, int row, int column, String parseMsg) {
        super(parseMsg);
        this.source = source;
        this.row = row;
        this.column = column;
    }




}
