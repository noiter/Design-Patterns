package noiter.designpattern.command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandReflectTest {

    private CommandReflect[] objects;

    @Before
    public void setUp() {
        objects = new CommandReflect[]{new CommandReflect(1), new CommandReflect(2)};
    }

    @Test
    public void test_normal_call_results() {

        assertEquals(4, objects[0].addOne(3));
        assertEquals(11, objects[1].addTwo(4, 5));
    }

    @Test
    public void test_reflation_call_results() {

        Command[] commands = {
                new Command(objects[0], "addOne", new Integer[]{3}),
                new Command(objects[1], "addTwo", new Integer[]{4, 5})};

        assertEquals(4, commands[0].execute());
        assertEquals(11, commands[1].execute());
    }
}
