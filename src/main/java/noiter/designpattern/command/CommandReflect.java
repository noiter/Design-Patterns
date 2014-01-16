package noiter.designpattern.command;

public class CommandReflect {
    private int state;

    public CommandReflect(int state) {
        this.state = state;
    }

    public int addOne(Integer one) {
        return state + one;
    }

    public int addTwo(Integer one, Integer two) {
        return state + one + two;
    }
}
