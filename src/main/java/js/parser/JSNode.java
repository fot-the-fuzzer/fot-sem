package js.parser;

import org.antlr.v4.runtime.misc.Interval;

public class JSNode {
    private Interval interval;

    public JSNode(Interval interval, String text) {
        this.interval = interval;
        this.text = text;
    }

    public Interval getInterval() {
        return interval;
    }

    public String getText() {
        return text;
    }

    private String text;

    @Override
    public String toString() {
        return "JSNode{" +
                "interval=" + interval +
                ", text='" + text + '\'' +
                '}';
    }
}
