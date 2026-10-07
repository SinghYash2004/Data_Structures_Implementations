package II_STACK;
/*
Can a linked list stack overflow?"
"Yes. It does not have a fixed capacity like an array stack, but it can still overflow when the system runs out of heap memory."

Isi wajah se practical applications me linked-list stack ko aksar dynamic-size stack kaha jata hai, unlimited-size stack nahi. */

class SNode{
    int data;
    SNode next;

    SNode(int data){
        this.data = data;
        this.next = null;
    }

}

public class Stack_List {
    SNode head;

    //stack mein addition opposite direction mein hota hai
    /*head
       ↓
      10 -> 20 -> 30 -> null 
      
      Ex: Push(5)
      head
       ↓
       5 -> 10 -> 20 -> 30 -> null

       matlab ye yaad rakho ki aab jo bhi element add hoga wo top pe add hoga
      */

// Adding element at the starting of the stack using push()
    void push(int data){
        SNode newNode = new SNode(data);
        
        if(head == null){
            head = newNode;
            return;
        }
        
        newNode.next = head;
        head = newNode;
    }


// Removing the topmost element from the stack using pop()
    void pop(){
        if(head == null){
            System.out.println("Stack UnderFlow Condition: Stack Empty.");
            return;
        }

        System.out.println("Poped Element: " + head.data);
        head = head.next;
    }


//To see the topmost element of the stack without removing using peek()
    void peek(){
        if(head == null){
            System.out.println("Stack UnderFlow Condition: Stack Empty.");
            return;
        }
        System.out.println("Top Element: " + head.data);
    }


//checking whether the stack is empty or not
    boolean isEmpty(){
        return head == null;
    }


// For printing all the elements of the stack
    void display(){
        if(head == null){
            System.out.println("Stack Empty.");
            return;
        }
        SNode temp = head;
        System.out.print("Top -> ");
        while(temp!=null){
            System.out.print(temp.data + " <- ");
            temp = temp.next;
        }
        System.out.println("null");
    }



// Will count the number of elements or nodes in the stack
    void size(){
        if(head == null){
            System.out.println("Stack Empty.");
            return;
        }
        int nodes = 0;
        SNode temp = head;
        while(temp!=null){
            nodes++;
            temp = temp.next;
        }
        System.out.println("Stack Length: " + nodes + ("."));
    }


//will clear the whole stack and will remove all elements from the stack
    void clear(){
        head = null;
    }
}

class input_stack_list{
    public static void main(String[] args) {
        Stack_List stack = new Stack_List();
        
        System.out.println("Stack Empty: "+stack.isEmpty());
        stack.pop();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.display();
        stack.size();
        stack.pop();
        stack.display();
        stack.size();
        System.out.println("Stack Empty: "+stack.isEmpty());

    }
}
