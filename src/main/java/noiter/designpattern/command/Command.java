package noiter.designpattern.command;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 "Sometimes it is necessary to issue requests to objects without knowing anything
 about the operation being requested or the receiver of the request."
 The Command design pattern suggests encapsulating ("wrapping") in an object all (or some) of the following:
 an object, a method name, and some arguments. Java does not support "pointers to methods",
 but its reflection capability will do nicely. The "command" is a black box to the "client".
 All the client does is call "execute()" on the opaque object.
 */

public class Command {
    private Object receiver;
    private Method action;
    private Object[] args;

    public Command(Object obj, String methodName, Object[] arguments) {
        receiver = obj;
        args = arguments;
        Class cls = obj.getClass();
        Class[] argTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++)
            argTypes[i] = args[i].getClass();
        try {
            action = cls.getMethod(methodName, argTypes);
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        }
    }

    public Object execute() {
        try {
            return action.invoke(receiver, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.out.println(e);
        }
        return null;
    }
}
