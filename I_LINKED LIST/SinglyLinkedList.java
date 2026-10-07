class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// 1. Insertion at end
// 2. Display a linked list
// 3. Insertion at beginning
// 4. Insertion at any position
// 5. Searching for a given number in the linked list
// 6. Deletion at end
// 7. Deletion at beginning
// 8. Deletion by value
// 9. Deletion by position
// 10. Count the number of nodes in the linked list
// 11. Reverse a linked list
// 12. Finding middle element
// 13. Detecting loop in a linked list
// 14. Nth node from the end of the linked list

public class SinglyLinkedList {
    // head ko hum global variable banayenge taki wo har jagah use kiya jaa sake.
    Node head;
    // yaha humne sirf ek reference variable declare kiya hai, koi Node object
    // create nahi kiya.
    // Java automatically reference variables ko null initialize kar deta hai.

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Insertion at the end %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void Insertion_at_end(int data) {

        Node newNode = new Node(data);
        // newNode ka data = data
        // newNode ka next node = Null

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        // yaha hum koi naya node create nahi kar rahe, hum sirf temp reference variable
        // ko head ke point kar rahe hai.
        // aur aab temp aur head dono same node ko point kar rahe hai, dono reference
        // variable same node ko point kar rahe hai.

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Display a linked list %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Insertion at the beginning %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void InsertionAtBegining(int data) {
        Node newNode = new Node(data);
        Node temp = head;
        newNode.next = temp;
        head = newNode;
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Insertion at any position %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void InsertionAtPosition(int data, int pos) {
        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Searching for a given number %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void Search(int num) {
        Node temp = head;
        int pos = 1;
        while (temp.next != null) {
            if (temp.data == num) {
                System.out.println(num + " exists in list at position " + pos + ".");
                return;
            } else {
                temp = temp.next;
                pos++;
            }
        }
        System.out.println(num + " does not exist in this list.");
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Deletion at end %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void DeletionAtEnd() {
        // Empty list
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // Only one node
        if (head.next == null) {
            System.out.println("Deleted node: " + head.data);
            head = null;
            return;
        }

        Node temp = head;
        // move to second last node
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // delete last node
        System.out.println("Deleted node: " + temp.next.data);
        temp.next = null;
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Deletion at the beginning %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void DeletionAtBeginning() {
        // Empty list
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Deleted node: " + head.data);
        head = head.next;
        // yaha humne head ko head ke next node pe point kar diya, aur purana head node
        // automatically garbage collected ho jayega.
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Deletion by value %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void DeleteByValue(int value) {
        if (head == null) { // Check if the list is empty
            System.out.println("List is empty");
            return;
        }

        if (head.data == value) { // If the value is present in the first node
            System.out.println("Deleted node: " + head.data);
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != value) { //// Find the node just before the node to be deleted
            temp = temp.next;
        }

        // Value not found in the list
        if (temp.next == null) {  //agr ye condition nhi lagaya toh temp.next.next NullPointerException wala error de dega
            System.out.println(value + " does not exist in the given list.");
            return;
        }

        System.out.println("Deleted node: " + temp.next.data);
        // Bypass the node containing the given value
        temp.next = temp.next.next;
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Deletion from given position %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void DeleteByPosition(int pos) {
        if (head == null) { // Check if the list is empty
            System.out.println("List is empty");
            return;
        }

        if (pos <= 0) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) { // If the position is 1, delete the head node
            System.out.println("Deleted node: " + head.data);
            head = head.next;
            return;
        }

        Node temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) { // Find the node just before the node to be deleted
            temp = temp.next;
        }

        // Position is out of bounds
        if (temp == null || temp.next == null) {
            System.out.println("Position " + pos + " does not exist in the given list.");
            return;
        }

        // Bypass the node at the given position
        System.out.println("Deleted node: " + temp.next.data);
        temp.next = temp.next.next;
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Count nodes %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void countNodes() {
        int count = 1;
        if (head == null) {
            System.out.println("List is Empty.");
            return;
        }
        if (head.next == null) {
            System.out.println("Length of this linked list: " + count + ".");
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of Nodes: " + count);
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Reverse a linked list %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void Reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // Store the next node
            current.next = prev; // Reverse the current node's pointer
            prev = current; // Move prev to the current node
            current = next; // Move to the next node
        }
        head = prev; // Update head to the new first node
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Find middle element %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void FindMiddle() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle element: " + slow.data);
    }

    /*
     Loop detect karne ke liye Floyd's Cycle Detection Algorithm (Tortoise and Hare) use hota hai.
       Idea
       slow pointer 1 step move karega.
       fast pointer 2 steps move karega.
       Agar loop hai, toh ek time par dono mil jayenge.
       Agar loop nahi hai, toh fast ya fast.next null ho jayega.
     */

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Detect loop %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void detectLoop() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by 1
            fast = fast.next.next; // Move fast pointer by 2

            if (slow == fast) { // Loop detected
                System.out.println("Loop detected in the linked list.");
                return;
            }
        }
        System.out.println("No loop detected in the linked list.");
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Detect loop %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void NthNodeFromEnd(int n){
        Node first = head;
        Node second = head;

        if(n<=0){
            System.out.println("Invalid Position.");
            return;
        }

        if(head == null){
            System.out.println("List Is Empty.");
            return;
        }

        for (int i = 1; i <= n ; i++) {
            if (second == null) {
                System.out.println("Invalid Position.");
                return;
            }
            second = second.next;
        }

        while(second!=null){
            first = first.next;
            second = second.next;
        }

        //the same above for loop and while loops can be written as
        /*
            for (int i = 1; i < n; i++) {
                 if (second.next == null) {
                     System.out.println("Invalid Position.");
                     return;
                }
                second = second.next;
            }
            
            while(second.next!=null){ 
                first = first.next;
                second = second.next; 
            }

         */

        System.out.println("Nth node from end: " + first.data);
    }
   
}

class input_output {
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.Insertion_at_end(10);
        list.Insertion_at_end(20);
        list.Insertion_at_end(30);
        list.Insertion_at_end(40);

        list.InsertionAtBegining(50);
        list.InsertionAtBegining(60);
        list.InsertionAtBegining(70);
        list.InsertionAtBegining(80);

        list.InsertionAtPosition(90, 5);
        list.InsertionAtPosition(100, 2);

        list.display();
        list.Reverse();
        list.display();
        list.Reverse();
        list.countNodes();

        list.NthNodeFromEnd(-1);
        list.NthNodeFromEnd(0);
        list.NthNodeFromEnd(1);
        list.NthNodeFromEnd(2);
        list.NthNodeFromEnd(3);
        list.NthNodeFromEnd(4);
        list.NthNodeFromEnd(5);
        list.NthNodeFromEnd(6);
        list.NthNodeFromEnd(7);
        list.NthNodeFromEnd(8);
        list.NthNodeFromEnd(9);
        list.NthNodeFromEnd(10);
        list.NthNodeFromEnd(11);
        list.NthNodeFromEnd(12);

        list.DeletionAtEnd();
        list.DeletionAtBeginning();
        list.DeleteByValue(50);
        list.DeleteByValue(200);

        list.display();
        list.countNodes();
        list.Search(70);
        list.Search(999);
        list.FindMiddle();
        list.detectLoop();
    }
}
