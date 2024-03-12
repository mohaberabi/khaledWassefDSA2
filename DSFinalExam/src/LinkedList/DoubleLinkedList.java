package LinkedList;

public class DoubleLinkedList<T> {


    static class Node<T> {
        Node<T> prev;
        Node<T> next;
        T data;

        public Node(T t) {
            data = t;
            prev = null;
            next = null;
        }
    }


    private int size;
    private Node<T> head;
    private Node<T> tail;

    public DoubleLinkedList() {
        size = 0;
        head = tail = null;
    }


    T deleteTail() {
        if (isEmpty()) {
            return null;
        }
        T data = tail.data;

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }


    boolean isEmpty() {
        return head == null;
    }

    T deleteHead() {
        if (isEmpty()) {
            return null;
        }

        T data = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }

    void addTail(T t) {
        Node<T> added = new Node<>(t);

        if (head == null) {
            head = added;
            tail = added;
        } else {
            tail.next = added;
            added.prev = tail;
            tail = added;
        }
        size++;
    }


    void displayFromTail() {
        Node<T> curr = tail;
        while (curr != null) {
            System.out.println(curr.data.toString());
            curr = curr.prev;
        }

    }

    void displayFromHead() {

        Node<T> curr = head;
        while (curr != null) {
            System.out.println(curr.data.toString());
            curr = curr.next;
        }


    }

    void addHead(T t) {
        Node<T> added = new Node<>(t);

        if (head == null) {
            head = added;
            tail = added;
        } else {
            head.prev = added;
            added.next = head;
            head = added;
        }
        size++;
    }

    public static void main(String[] args) {

        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.addHead(1);
        doubleLinkedList.addHead(2);
        doubleLinkedList.addHead(3);
        doubleLinkedList.addHead(4);
        doubleLinkedList.displayFromTail();
    }
}
