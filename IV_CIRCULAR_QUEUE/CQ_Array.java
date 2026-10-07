package IV_CIRCULAR_QUEUE;

public class CQ_Array {
    int[] arr;
    int capacity;
    int front;
    int rear;

    CQ_Array(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    boolean isEmpty() {
        return front == -1;
    }

    void Enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
            arr[rear] = 0;
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = data;
    }

    void Dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow.");
            return;
        }
        System.out.println("Deleted Element: " + arr[front]);
        if (front == rear)
            front = rear = -1;
        else
            front = (front + 1) % capacity;
    }

    void peek() {

        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }

        System.out.println("Front Element: " + arr[front]);
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue Underflow.");
            return;
        }
        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");

            if (i == rear) {
                break;
            }
            i = (i + 1) % capacity;
        }
        System.out.println();
    }
}
