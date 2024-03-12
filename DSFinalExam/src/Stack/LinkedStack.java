package Stack;

public class LinkedStack<T> {


    private Node<T> head;

    private int size;


    public LinkedStack() {

        head = null;
        size = 0;
    }


    T peek() {
        return head.data;
    }


    boolean isEmpty() {
        return size == 0;
    }

    T pop() {
        if (head == null) {
            return null;
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    int size() {
        return size;
    }

    void push(T t) {
        Node<T> added = new Node<>(t);
        if (head == null) {
            head = added;
        } else {
            added.next = head;
            head = added;
        }
        size++;
    }

    private static class Node<T> {

        Node<T> next;
        T data;

        public Node(T t) {
            data = t;
            next = null;
        }
    }
}
