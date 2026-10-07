package III_QUEUE;

//Queue follows FIFO (First In First Out)
//insertion always from rear : Enqueue
//deletion always from front : Dequeue

public class Queue_Array {
    int[] arr;
    int front;
    int rear;
    int capacity;

    Queue_Array(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

    boolean isFull() {
        return rear == capacity - 1;
    }

    boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    void Enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow: Queue full.");
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        arr[++rear] = data;
    }

    void Dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow: Queue Empty.");
            return;
        }
        System.out.println("Deleted Element: " + arr[front]);
        front++;
        if (front > rear) { //when last element is deleted
            front = rear = -1;
        }
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
            System.out.println("Queue Empty");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}


class input3{
    public static void main(String[] args) {
        Queue_Array queue = new Queue_Array(5);
        System.out.println("Queue Empty: " + queue.isEmpty());
        System.out.println("Queue Full: " + queue.isFull());
        
        queue.Enqueue(10);
        queue.Enqueue(20);
        queue.Enqueue(30);
        queue.Enqueue(40);
        queue.Enqueue(50);

        queue.display();
        System.out.println("Queue Empty: " + queue.isEmpty());
        System.out.println("Queue Full: " + queue.isFull());

    }
}