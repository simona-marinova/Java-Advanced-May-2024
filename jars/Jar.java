package jars;

import java.util.ArrayDeque;

public class Jar<T> {
    //•	void add(element)
    //•	element remove()
    private ArrayDeque<T> stack;

    public Jar() {
        this.stack = new ArrayDeque<>();
    }

    public void add(T element) {
        this.stack.push(element);
    }

    public T remove() {
        return this.stack.pop();
    }

}
