package common;

import org.antlr.v4.runtime.misc.Interval;

public class MutNode {
    private Interval interval;

    public MutNode(Interval interval, String text) {
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
        return "MutNode{" +
                "interval=" + interval +
                ", text='" + text + '\'' +
                '}';
    }
}
