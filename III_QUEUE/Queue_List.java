package III_QUEUE;

class QNode {
    int data;
    QNode next;

    QNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Queue_List {
    QNode front, rear;

    boolean isEmpty() {
        return front == null && rear == null;
    }

    void Enqueue(int data) {
        QNode newNode = new QNode(data);
        if (isEmpty()) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    void Dequeue() {
        if (isEmpty()) {
            System.out.println("Underflow Condition: Queue Empty.");
            return;
        }
        System.out.println("Deleted Element: " + front.data);
        if (front == rear) {
            front = rear = null;
            return;
        }
        front = front.next;
    }

    void peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Front Element: " + front.data);
    }

    void display() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        QNode temp = front;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }
}
