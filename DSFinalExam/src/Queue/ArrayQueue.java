package Queue;

import Stack.ArrayStack;

public class ArrayQueue {


    int size;
    int capacity;
    int[] arr;

    public ArrayQueue() {
        size = 0;
        capacity = 10;
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
        arr[size++] = x;
    }


    int rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[size - 1];
    }

    int front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[0];
    }

    void dequeue() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }
}
