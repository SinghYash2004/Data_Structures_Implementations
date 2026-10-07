package IV_CIRCULAR_QUEUE;

class CNode {
    int data;
    CNode next;

    CNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CQ_List {
    CNode front, rear;

    boolean isEmpty() {
        return front == null;
    }

    void Enqueue(int data) {
        CNode newNode = new CNode(data);
        if (isEmpty()) {
            front = rear = newNode;
            rear.next = front;
            return;
        }
        rear.next = newNode;
        rear = newNode;
        rear.next = front;
    }

    void Dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow.");
            return;
        }
        System.out.println("Deleted Element: " + front.data);

        // Single node
        if (front == rear) {
            front = rear = null;
            return;
        }
        front = front.next;
        rear.next = front;
    }

    void peek() {

        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }

        System.out.println("Front Element: " + front.data);
    }

    void display() {

        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }

        CNode temp = front;

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);

        System.out.println();
    }
}
