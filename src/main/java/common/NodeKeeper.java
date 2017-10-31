package common;

import org.antlr.v4.runtime.misc.Interval;

import java.util.*;

public class NodeKeeper {

    public NodeKeeper() {
        this.fragments = new ArrayList<>();
    }

    /**
     * this API may be changed
     * @param map
     */
    public NodeKeeper(Map<Interval, String> map) {
        this.fragments = new ArrayList<>();
        for(Map.Entry<Interval, String> entry: map.entrySet()) {
            MutNode node = new MutNode(entry.getKey(), entry.getValue());
            this.fragments.add(node);
        }
    }

    public int size() {
        return this.fragments.size();
    }

    private List<MutNode> fragments;

    public MutNode get(int index) {
        return this.fragments.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("fragments (size=").append(fragments.size()).append(")\n");
        for (MutNode entry : fragments) {
            sb.append(entry).append("\n");
        }
        return sb.toString();
    }
}
