package js.parser;

import org.antlr.v4.runtime.misc.Interval;

import java.util.*;

public class NodeKeeper {

    public NodeKeeper() {
        this.fragments = new ArrayList<>();
    }

    public NodeKeeper(Map<Interval, String> map) {
        this.fragments = new ArrayList<>();
        for(Map.Entry<Interval, String> entry: map.entrySet()) {
            JSNode node = new JSNode(entry.getKey(), entry.getValue());
            this.fragments.add(node);
        }
    }

    public int size() {
        return this.fragments.size();
    }

    private List<JSNode> fragments;

    public JSNode get(int index) {
        return this.fragments.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("fragments (size=").append(fragments.size()).append(")\n");
        for (JSNode entry : fragments) {
            sb.append(entry).append("\n");
        }
        return sb.toString();
    }
}
