package Stack;

public class ArrayStack {


    int[] stack;
    int top;
    int size;
    int capacity;

    public ArrayStack() {
        stack = new int[10];
        top = -1;
        size = 0;
        capacity = 10;
    }


    void push(int x) {
        if (isFull()) {
            return;
        }
        stack[++top] = x;
        size++;
    }


    int peek() {
        if (isEmpty()) {
            return -1;
        }
        return stack[top];
    }

    int pop() {
        if (isEmpty()) {
            return -1;
        }
        size--;
        return stack[top--];

    }

    private boolean isFull() {

        return size == capacity;
    }

    boolean isEmpty() {
        return size == 0;
    }
}
