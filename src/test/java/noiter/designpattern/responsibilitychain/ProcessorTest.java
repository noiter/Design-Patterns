package noiter.designpattern.responsibilitychain;

import org.junit.Test;

public class ProcessorTest {
    @Test
    public void test_three_processors_handle_different_requests() {

        Image[] input = {new IR(), new IR(), new LS(), new IR(), new LS(), new LS()};
        Processor[] processors = {new Processor(), new Processor(), new Processor()};

        for (int i = 0, j; i < input.length; i++) {
            j = 0;
            while (!processors[j].handle(input[i]))
                j = (j + 1) % processors.length;
        }
    }
}
