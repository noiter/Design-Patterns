package noiter.designpattern.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Enumeration;

public class IntSetTest {

    private IntSet intSet;

    @Before
    public void setUp() {

        intSet = new IntSet();
        for (int i = 2; i < 10; i += 2) {
            intSet.add(i);
        }
    }

    @Test
    public void test_iterate_elements_have_same_protocols() {

        // 3. Clients ask the collection object to create many iterator objects
        IntSet.Iterator it1 = intSet.createIterator();
        IntSet.Iterator it2 = intSet.createIterator();

        // 4. Clients use the first(), isDone(), next(), currentItem() protocol
        System.out.println("Iterator:    ");
        for (it1.first(), it2.first(); !it1.isDone(); it1.next(), it2.next())
            System.out.print(it1.currentItem() + " " + it2.currentItem() + "  ");

    }

    @Test
    public void test_iterate_element_with_original_java() {

        System.out.println("\nEnumeration: ");
        for (Enumeration e = intSet.getHashTable().keys(); e.hasMoreElements(); )
            System.out.print(e.nextElement() + "  ");
        System.out.println();

    }
}
