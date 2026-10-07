class DLLNode {
    int data;
    DLLNode prev;
    DLLNode next;

    DLLNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

}

// 1. Insertion at the end
// 2. Insertion at the beginning
// 3. Insertion at any position 
// 4. Deletion at the end
// 5. Deletion at the beginning
// 6. Deletion at any position
// 7. Displaying a linked list
// 8. Display in reverse order

public class DoublyLinkedList {
    DLLNode head;

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Insertion at the end %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void InsertAtEnd(int data) {
        DLLNode newNode = new DLLNode(data);

        if (head == null) {
            head = newNode;
            return;
        }

        DLLNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Insertion at the beginning %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void InsertAtBegining(int data) {
        DLLNode newNode = new DLLNode(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Insertion at any position %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void InsertAtPosition(int data, int pos) {
        DLLNode newNode = new DLLNode(data);

        if (pos <= 0) {
            System.out.println("Incorrect Position.");
            return;
        }

        if (pos == 1) {
            InsertAtBegining(data);
            return;
        }

        DLLNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position;");
            return;
        }

        // End insertion case
        if (temp.next == null) {
            temp.next = newNode;
            newNode.prev = temp;
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        temp.next.prev = newNode;
        temp.next = newNode;
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Deletion at the end %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void DeleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        // Single node
        if (head.next == null) {
            head = null;
            return;
        }

        DLLNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
        temp.prev = null;

        /*  deletion usind 2nd last node
        while (temp.next.next != null){
            temp = temp.next;
        }

        temp.next.prev= null;
        temp.next = null;
    */
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Deletion at the beginning %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void DeleteAtBeginning(){
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Deletion at any position %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void DeleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (pos <= 0) {
            System.out.println("Incorrect Position.");
            return;
        }
        if (pos == 1) {
            DeleteAtBeginning();
            return;
        }

        DLLNode temp = head;
        for (int i = 1; i < pos && temp != null; i++) {
            /* 
            1. yaha hum pos-1 use isiliye nahi kar rhe hai kyuki hum temp ko uss exact node pe point karna chahte hai
                  jis node ko hume delete karna hai.
            2. insertion ke time agr hume bola jaata hai ki nth pos se insertion karna hai tab hum (n-1)th node pe point 
                  karte hai jiske liye hume (pos-1) ka jarurat padta hai
            */
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid Position;");
            return;
        }

        // End deletion case
        if (temp.next == null) {
            temp.prev.next = null;
            temp.prev = null;
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        temp.prev = null;
        temp.next = null;
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Displaying a linked list %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void display() {
        DLLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Display in reverse order %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    void displayReverse() {
        DLLNode temp = head;

        while(temp.next!=null){
            temp=temp.next;
        }

        while(temp!=null){
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("Null");
    }
    

}

class dll {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.InsertAtEnd(10);
        list.InsertAtEnd(20);
        list.InsertAtEnd(30);
        list.InsertAtEnd(40);
        list.InsertAtEnd(50);
        list.InsertAtBegining(60);
        list.InsertAtBegining(70);
        list.InsertAtBegining(80);
        list.InsertAtBegining(90);
        list.InsertAtBegining(100);
        list.InsertAtPosition(110, 3);
        list.InsertAtPosition(120, 7);
        list.InsertAtPosition(120, 90);
        list.display();
        list.displayReverse();

    }
}

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

class DLL_Tail{
    DLLNode  head;
    DLLNode tail;

    void InsertAtEnd(int data){
        DLLNode newNode = new DLLNode(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.prev=tail;
        tail.next = newNode;
        tail = newNode;
    }

    void InsertAtBeginning(int data) {
        DLLNode newNode = new DLLNode(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head =  newNode;
    }

    void InsertAtPosition(int data, int pos){
        if(pos<=0){
            System.out.println("Invalid Position");
            return;
        }
        if(pos==1){
            InsertAtBeginning(data);
            return;
        }
        DLLNode newNode =  new DLLNode(data);
        DLLNode temp = head;
        
        for(int i=1; i<pos-1 && temp != null; i++){
            temp=temp.next;
        }

        if(temp==null){
            System.out.println("Invalid Position.");
            return;
        }

        newNode.prev = temp;
        newNode.next =  temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

}