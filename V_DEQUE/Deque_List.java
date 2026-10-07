package V_DEQUE;

class DNode {
    int data;
    DNode next;
    DNode prev;

    DNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class Deque_List {
    DNode front, rear;

    boolean isEmpty() {
        return front == null && rear == null;
    }

    void EnqueueFront(int data) {
        DNode newNode = new DNode(data);
        if (isEmpty()) {
            front = rear = newNode;
            return;
        }
        newNode.next = front;
        front.prev = newNode;
        front = newNode;
    }

    void EnqueueRear(int data) {
        DNode newNode = new DNode(data);
        if (isEmpty()) {
            front = rear = newNode;
            return;
        }
        newNode.prev = rear;
        rear.next = newNode;
        rear = newNode;
    }

    void DequeueFront() {
        if (isEmpty()) {
            System.out.println("Deque Underflow Condition. (Deque Front)");
            return;
        }
        System.out.println("Dequeued Element (Front): " + front.data);
        if (front == rear) {
            front = rear = null;
            return;
        }
        front.next.prev = null;
        front = front.next;
    }

    void DequeueRear() {
        if (isEmpty()) {
            System.out.println("Deque Underflow Condition. (Deque Rear)");
            return;
        }
        System.out.println("Dequeued Element (Rear): " + rear.data);
        if (front == rear) {
            front = rear = null;
            return;
        }
        rear = rear.prev;
        rear.next = null;
    }

    void getFront() {
        if (isEmpty()) {
            System.out.println("Deque is Empty.");
            return;
        }

        System.out.println("Front Element: " + front.data);
    }

    void getRear() {
        if (isEmpty()) {
            System.out.println("Deque is Empty.");
            return;
        }

        System.out.println("Rear Element: " + rear.data);
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Deque is Empty.");
            return;
        }
        DNode temp = front;

        System.out.print("Deque: ");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    // Displays all elements from rear to front
    void DisplayReverse() {
        if (isEmpty()) {
            System.out.println("Deque is Empty.");
            return;
        }

        DNode temp = rear;

        System.out.print("Deque (Reverse): ");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }

        System.out.println();
    }

}
