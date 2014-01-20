package noiter.designpattern.iterator;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.NoSuchElementException;

/*
Need to "abstract" the traversal of wildly different data structures
so that algorithms can be defined that are capable of interfacing with each transparently.
 */

public class IntSet {

    private Hashtable table;

    public IntSet() {
        this.table = new Hashtable();
    }

    // 1. Design an internal "iterator" class for the "collection" class
    public static class Iterator {
        private IntSet set;
        private Enumeration e;
        private Integer current;

        public Iterator(IntSet in) {
            set = in;
        }

        public void first() {
            e = set.table.keys();
            next();
        }

        public boolean isDone() {
            return current == null;
        }

        public int currentItem() {
            return current;
        }

        public void next() {
            try {
                current = (Integer) e.nextElement();
            } catch (NoSuchElementException e) {
                current = null;
            }
        }
    }

    public void add(int in) {
        table.put(in, "null");
    }

    public boolean isMember(int i) {
        return table.containsKey(new Integer(i));
    }

    public Hashtable getHashTable() {
        return table;
    }

    // 2. Add a createIterator() member to the collection class
    public Iterator createIterator() {
        return new Iterator(this);
    }
}
