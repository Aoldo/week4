package assignments.uber.clientserver;

import static java.lang.System.out;

/**
 * This is the "application", what the server works with
 */
public class Calculator {
    public int add(int i1, int i2) {
        out.println("Add called");
        return i1 + i2;
    }

    public int subtract(int i1, int i2) {
        return i1 - i2;
    }
}
