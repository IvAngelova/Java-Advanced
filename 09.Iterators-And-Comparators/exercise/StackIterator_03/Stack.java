package T9IteratorsAndComparators.exercise.StackIterator_03;

import java.util.Iterator;

public class Stack<Integer> implements Iterable<Integer> {

    private class Node<Integer> {
        private int element;
        private Node<Integer> prev;

        public Node(int element) {
            this.element = element;
            this.prev = null;
        }
    }

    private Node<Integer> top;

    public Stack() {
        this.top = null;
    }

    public void push(int newElement) {
        Node<Integer> newNode = new Node<>(newElement);
        newNode.prev = this.top;
        this.top = newNode;

    }

    public int pop() throws Exception {
        if (this.top == null) {
            throw new Exception("Empty stack");
        } else {
            Node<Integer> currentTop = this.top;
            this.top = currentTop.prev;
            return currentTop.element;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            private Node<Integer> current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Integer next() {
                int currentValue = current.element;
                current = this.current.prev;
                return (Integer) java.lang.Integer.valueOf(currentValue);
            }
        };
    }

}
