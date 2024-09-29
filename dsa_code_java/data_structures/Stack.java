package dsa_code_java.data_structures;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    List<Integer> stack = new ArrayList<Integer>();

    public Stack() {
    }

    public void push(int n) {
        stack.add(n);
    }

    public int pop() {
        return stack.remove(stack.size() - 1);
    }

    public int size() {
        return stack.size();
    }

}
