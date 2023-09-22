package stacks;

public class IntQueue {
    public int[] data;  // The data structure (an array) to store the queue
    private int front;   // Index of the front element (remove from here)
    private int rear;    // Index where the next element should be added

    // Constructor to initialize the queue
    public IntQueue(int size) {
        data = new int[size];
        front = 0;
        rear = 0;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == rear;
    }

    // Dequeue (remove and return) the front element of the queue
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = data[front];
        front = (front + 1) % data.length;
        return value;
    }

    // Enqueue (add) an element to the rear of the queue
    public void enqueue(int x) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        data[rear] = x;
        rear = (rear + 1) % data.length;
    }

    public boolean isFull() {
        return (rear + 1) % data.length == front;
    }
    
    public int size() {
        if (rear >= front) {
            return rear - front;
        } else {
            return data.length - (front - rear);
        }
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int size = size();

        for (int i = 0; i < size; i++) {
            sb.append(data[(front + i) % data.length]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}