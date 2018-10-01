package PostfixEvaluator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class DoubleStack {

    private Deque<Double> stack;

    public DoubleStack() {
        stack = new ArrayDeque<>();
    }

    @Override
    public String toString() {
        return "DoubleStack{" + stack + '}';
    }

    public void push(double val) {
        stack.push(val);
    }

    public double pop() {
        return stack.pop();
    }
}
