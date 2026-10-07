package V_DEQUE;

public class Deque_Array {
    int[] deque;
    int front;
    int rear;
    int capacity;

    
// Constructor: Initializes the deque with the specified capacity
    Deque_Array(int capacity) {
        this.capacity = capacity;
        deque = new int[capacity];
        this.front = -1;
        this.rear = -1;
    }

// Checks whether the deque is full
    boolean isFull() {
        return (rear + 1) % capacity == front;
    }

// Checks whether the deque is empty
    boolean isEmpty() {
        return front == -1 && rear == -1;
    }


// Inserts an element at the front of the deque
    void EnqueueFront(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow condition. (Enqueue Front) ");
            return;
        } else if (isEmpty()) {
            front = rear = 0;
            deque[front] = data;
            return;
        } else if (front == 0) {
            front = capacity - 1;
            deque[front] = data;
            return;
        } else {
            deque[--front] = data;
        }
    }

// Inserts an element at the rear of the deque
    void EnqueueRear(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow condition. (Enqueue Rear)");
            return;
        } else if (isEmpty()) {
            front = rear = 0;
            deque[rear] = data;
            return;
        } else if (rear == capacity - 1) {
            rear = (rear + 1) % capacity;
            deque[rear] = data;
            return;
        } else {
            deque[++rear] = data;
        }
    }


// Deletes an element from the front of the deque
    void DequeueFront() {
        if (isEmpty()) {
            System.out.println("Deque Undeflow Condition. (Dequeue Front)");
            return;
        }
        if (front == rear) {
            System.out.println("Dequeued Element (Front): " + deque[front]);
            front = rear = -1;
            return;
        }
        if (front == capacity - 1) {
            System.out.println("Dequeued Element (Front): " + deque[front]);
            front = 0;
            return;
        }
        System.out.println("Dequeued Element (Front): " + deque[front]);
        front++;
    }


// Deletes an element from the rear of the deque
    void DequeueRear() {
        if (isEmpty()) {
            System.out.println("Deque Undeflow Condition. (Dequeue Rear)");
            return;
        }
        System.out.println("Dequeued Element (Rear): " + deque[rear]);
        if (front == rear) {
            front = rear = -1;
        } else if (rear == 0) {
            rear = capacity - 1;
        } else {
            rear--;
        }
    }


// Displays all elements present in the deque.
    void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }
        int i = front;
        System.out.print("Deque elements: ");
        while (true) {
            System.out.print(deque[i] + " ");
            if (i == rear) {
                break;
            }

            i = (i + 1) % capacity;
        }
        System.out.println();
    }


// Displays the front element of the deque
    void getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }
        System.out.println("Front Element: " + deque[front]);
    }


// Displays the rear element of the deque
    void getRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }
        System.out.println("Rear Element: " + deque[rear]);
    }
}



class input5 {
    public static void main(String[] args) {
        Deque_Array deque = new Deque_Array(5);
        deque.DequeueFront();
        deque.DequeueRear();

        deque.EnqueueFront(10);
        deque.EnqueueRear(20);
        deque.EnqueueFront(30);
        deque.EnqueueRear(40);
        deque.EnqueueFront(50);
        deque.EnqueueFront(60);
        deque.EnqueueRear(60);
        deque.display();
        deque.getFront();
        deque.getRear();

        deque.DequeueFront();
        deque.DequeueRear();
        deque.display();
        deque.getFront();
        deque.getRear();
    }
}
