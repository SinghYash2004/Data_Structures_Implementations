// 1. Create Circular Linked List
// 2. Insert at Beginning
// 3. Insert at End
// 4. Insert at Position
// 5. Delete at Beginning
// 6. Delete at End
// 7. Delete at Position
// 8. Search Element
// 9. Count Nodes
// 10. Display List
// 11. Reverse List

class CLNode {
    int data;
    CLNode next;

    CLNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    CLNode head;

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Insert At End %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void InsertAtEnd(int data) {
        CLNode newNode = new CLNode(data);

        if (head == null) { // when no element is present
            head = newNode;
            head.next = head; // aab head ka next khud ko hi point karega jisse ek circular loop jaisa create ho jayega
            return;
        }

        CLNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode; // creating link
        newNode.next = head; // pointing last element to the head
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Insert At Beginning %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void InsertAtBeginning(int data) {
        CLNode newNode = new CLNode(data);

        if (head == null) { // when no element is present
            head = newNode;
            head.next = head;
            return;
        }

        CLNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        newNode.next = head;
        head = newNode;
        temp.next = head;

    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Insert At Position %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void InsertAtPosition(int data, int pos) {
        CLNode newNode = new CLNode(data);

        if (head == null) {
            if (pos == 1) {
                head = newNode;
                head.next = head;
            } else {
                System.out.println("Invalid Position.");
            }
            return;
        }

        if (pos <= 0) {
            System.out.println("Invalid Position.");
            return;
        }

        CLNode temp = head;
        for (int i = 1; i < pos - 1; i++) {
            if (temp.next == null) {
                System.out.println("Invalid Position.");
                return;
            }
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Delete At End %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void DeleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }
        CLNode temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }
        temp.next.next = null;
        temp.next = head;
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Delete At Beginning %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void DeleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }
        CLNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        head = head.next;
        temp.next = head;
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Delete At Position %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void DeleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (pos <= 0) {
            System.out.println("Invalid Position.");
            return;
        }

        if (pos == 1) {
            DeleteAtBeginning();
            return;
        }

        CLNode temp = head;
        for (int i = 1; i < pos - 1; i++) {
            if (temp.next == null) {
                System.out.println("Invalid Position.");
                return;
            }
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Invalid Position.");
            return;
        }

        temp.next = temp.next.next;
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Count Nodes %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void CountNodes(){
        if(head == null){
            System.out.println("List is empty.");
            return;
        }

        int count = 0;
        CLNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Number of nodes in the list: " + count);
    }


//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Search Element %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void SearchElement(int key) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        CLNode temp = head;
        int pos = 1;
        do {
            if (temp.data == key) {
                System.out.println("Element " + key + " found at position: " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        } while (temp != head);

        System.out.println("Element " + key + " not found in the list.");
    }


//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Display List %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void Display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        CLNode temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(head)");
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Reverse List %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void Reverse() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        CLNode prev = null;
        CLNode current = head;
        CLNode next = null;

        do {
            next = current.next; // Store next node
            current.next = prev; // Reverse current node's pointer
            prev = current; // Move prev to current
            current = next; // Move to next node
        } while (current != head);

        head.next = prev; // Make the last node point to the new head
        head = prev; // Update head to the new first node
    }
}

class input_output2{
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        cll.InsertAtEnd(10);
        cll.InsertAtEnd(20);
        cll.InsertAtEnd(30);
        cll.Display();

        cll.InsertAtBeginning(5);
        cll.Display();

        cll.InsertAtPosition(15, 3);
        cll.Display();

        cll.DeleteAtEnd();
        cll.Display();

        cll.DeleteAtBeginning();
        cll.Display();

        cll.DeleteAtPosition(2);
        cll.Display();

        cll.CountNodes();

        cll.SearchElement(20);
        cll.SearchElement(40);
    }
}
