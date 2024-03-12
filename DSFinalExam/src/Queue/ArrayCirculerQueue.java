package Queue;

public class ArrayCirculerQueue {


    private int size;
    private int capacity;
    private int front;


    private int[] arr;

    public ArrayCirculerQueue() {
        size = 0;
        capacity = 10;
        front = 0;
        arr = new int[10];
    }


    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == capacity;
    }

    void enqueue(int x) {
        if (isFull()) {
            return;

        }

        int rear = rear();
        int newRear = rear + 1 % capacity;

        arr[newRear] = x;
        size++;

    }

    void dequeue() {
        if (isEmpty()) {
            return;
        }
        front = front + 1 % capacity;

        size--;
    }

    int rear() {
        return (front + size - 1) % capacity;
    }

}
