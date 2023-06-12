package Stack自写版;

import java.util.*;

public class Stack {
    public static void main(String[] args) {

    }

}

class EmptyStackException extends RuntimeException {

    public EmptyStackException() {
        super();
    }

    public EmptyStackException(String message) {
        super(message);
    }
}

class Estack<E> {

    ArrayList<E> stack = new ArrayList<>();
    // 手写stack
    int top = 0;

    public void push(E e) {
        stack.add(e);
        top++;
    }

    public E pop() {
        if (top == 0) {
            throw new EmptyStackException();
        }
        E e = stack.get(top - 1);
        stack.remove(top - 1);
        top--;
        return e;
    }

    public E peek() {
        if (top == 0) {
            throw new EmptyStackException();
        }
        return stack.get(top - 1);
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }

    public String toString() {
        return stack.toString();
    }

    public void reverse() {
        for (int i = 0; i < top / 2; i++) {
            E temp = stack.get(i);
            stack.set(i, stack.get(top - i - 1));
            stack.set(top - i - 1, temp);
        }
    }
}
