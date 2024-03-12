package Queue;

public class LinkedQueue<T> {

    private static class Node<T> {
        T data;
        Node<T> next;


        public Node(T t) {
            this.data = t;
        }
    }


    private Node<T> front;

    private int size;

    public LinkedQueue() {
        size = 0;
        front = null;
    }


    T peek() {
        return front.data;
    }

    boolean isEmpty() {
        return front == null;
    }

    T dequeue() {
        if (front == null) {
            return null;
        }

        T deq = front.data;
        front = front.next;
        size--;
        return deq;
    }

    void enqueue(T t) {

        Node<T> added = new Node<>(t);
        if (front == null) {
            front = added;
            size++;
        } else {
            front.next = added;
            size++;
        }

    }
}
