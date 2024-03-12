package LinkedList;

public class MyLinkedList<T> {


    static class Node<T> {
        Node<T> next;
        T data;

        public Node(T t) {
            data = t;
            next = null;
        }
    }


    private Node<T> head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    void addHead(T t) {

        Node<T> added = new Node<T>(t);
        if (head != null) {
            added.next = head;
        }
        head = added;

        size++;

    }

    int size() {
        return size;
    }

    boolean delete(T t) {

        if (head == null) {
            return false;
        }

        if (head.data.equals(t)) {
            head = head.next;
            size--;
            return true;
        }
        Node<T> curr = head;
        while (curr.next != null && !curr.next.data.equals(t)) {
            curr = curr.next;
        }
        if (curr.next != null && curr.next.data.equals(t)) {
            curr.next = curr.next.next;
            size--;
            return true;
        }
        return false;
    }

    T removeFromHead() {
        if (head == null) {
            return null;
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    boolean find(T t) {
        if (head == null) {
            return false;
        }
        Node<T> curr = head;

        while (curr != null && !curr.data.equals(t)) {
            curr = curr.next;
        }
        return curr != null;
    }


    T head() {
        return head.data;
    }

    void display() {
        Node<T> curr = head;
        while (curr != null) {
            System.out.println(curr.data.toString());
            curr = curr.next;
        }
    }

    public static void main(String[] args) {

        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addHead(1);

        linkedList.addHead(2);
        linkedList.addHead(3);

        boolean del = linkedList.delete(3);

        System.out.println(del);

////        boolean found = linkedList.find(2);
////        System.out.println(found);
////        linkedList.delete(1);
////        linkedList.display();
//        boolean found = linkedList.find(1);
//        System.out.println(found);
    }

}
