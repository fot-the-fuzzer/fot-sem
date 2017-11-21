package common;

import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.misc.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Mutator {

    private Logger logger = LoggerFactory.getLogger(Mutator.class);

    private Random rnd = ThreadLocalRandom.current();

    // TODO more cases
    private void insertAfter(TokenStreamRewriter rewriter, Interval interval, String text) {
        rewriter.insertAfter(interval.b, text);
    }

    // TODO more cases
    private void insertBefore(TokenStreamRewriter rewriter, Interval interval, String text) {
        rewriter.insertBefore(interval.b, text);
    }

    private void delete(TokenStreamRewriter rewriter, Interval interval) {
        rewriter.delete(interval.a, interval.b);
    }

    private void replace(TokenStreamRewriter rewriter, Interval interval, String text) {
        rewriter.replace(interval.a, interval.b, text);
    }

    public String random(TokenStreamRewriter rewriter, NodeKeeper keeper) {
        String text = null;
        int res = this.rnd.nextInt(3);
        switch (res) {
            case 0:
                text = this.insert(rewriter, keeper);
                break;
            case 1:
                text = this.delete(rewriter, keeper);
                break;
            case 2:
                text = this.replace(rewriter, keeper);
                break;
        }
        return text;
    }

    public String insert(TokenStreamRewriter rewriter, NodeKeeper keeper) {
        logger.debug("insert...");
        int size = keeper.size();
        int i1 = rnd.nextInt(size);
        MutNode n1 = keeper.get(i1);
        int i2 = rnd.nextInt(size);
        MutNode n2 = keeper.get(i2);
        if (rnd.nextBoolean()) {
            this.insertAfter(rewriter, n1.getInterval(), n2.getText());
        } else {
            this.insertBefore(rewriter, n1.getInterval(), n2.getText());
        }
        return rewriter.getText();
    }

    public String delete(TokenStreamRewriter rewriter, NodeKeeper keeper) {
        logger.debug("delete...");
        int idx = rnd.nextInt(keeper.size());
        MutNode node = keeper.get(idx);
        this.delete(rewriter, node.getInterval());
        return rewriter.getText();
    }

    public String replace(TokenStreamRewriter rewriter, NodeKeeper keeper) {
        logger.debug("replace...");
        int size = keeper.size();
        int i1 = rnd.nextInt(size);
        int i2 = rnd.nextInt(size);
        // TODO should handle precisely later
        if (i1 == i2) {
            return rewriter.getText();
        }
        MutNode n1 = keeper.get(i1);
        MutNode n2 = keeper.get(i2);
        this.replace(rewriter, n1.getInterval(), n2.getText());
        return rewriter.getText();
    }
}
