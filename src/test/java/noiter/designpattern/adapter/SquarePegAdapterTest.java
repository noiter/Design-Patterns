package noiter.designpattern.adapter;

import org.junit.Test;

public class SquarePegAdapterTest {

    @Test
    public void test_replace_old_one_with_new_one_but_keep_supporting_old_one() {

        RoundHole rh = new RoundHole(5);

        SquarePegAdapter spa;

        for (int i = 6; i < 10; i++) {
            spa = new SquarePegAdapter((double) i);
            spa.makeFit(rh);
        }

    }
}
