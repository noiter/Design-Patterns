package noiter.designpattern.responsibilitychain;

import java.util.Random;

/*
Chain of Responsibility simplifies object interconnections.
Instead of senders and receivers maintaining references to all candidate receivers,
each sender keeps a single reference to the head of the chain,
and each receiver keeps a single reference to its immediate successor in the chain.
 */

public class Processor {
    private static Random rn = new Random();
    private static int nextId = 1;
    private int id = nextId++;

    public boolean handle(Image img) {
        if (rn.nextInt(2) != 0) {
            System.out.println("   Processor " + id + " is busy");
            return false;
        }
        System.out.println("Processor " + id + " - " + img.process());
        return true;
    }
}
