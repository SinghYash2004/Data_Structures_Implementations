package II_STACK;

//follows LIFO (Last In First Out) principle
//operations: push, pop, peek, isEmpty, isFull, size
//Index value of top is -1 when stack is empty
//Index values are same as array index values and start from 0 to n-1 where n is the size of the stack
//Uses static memory allocation and is faster than stack using linked list


public class Stack_Array {
    int[] arr;
    int top;
    int capacity;

    Stack_Array(int capacity){
        this.capacity= capacity;
        arr = new int[capacity];
        top =-1;
    }


    private boolean isFull(){
        if(top + 1  == capacity){
            return true;
        }
        return false;
        //return top == capacity-1;
    }

    private boolean isEmpty(){
        return top==-1;
    }

    void push(int data){
        if(isFull()){
            System.out.println("Stack overflow condition.");
            return;
        }
        arr[++top]=data;
    }

    void pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow Condition.");
            return;
        }
        System.out.println("Deleted Element: " + arr[top--]);
    }

    void peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty.");
            return;
        }
        System.out.println("Top element: " + arr[top]);
    }

    void isFullInfo(){
        if(isFull()){
            System.out.println("Stack is Full.");
            return;
        }
        System.out.println("Stack is not Full.");
        System.out.println("Stack has " + size() + " number of Elments.");
    }

    void isEmptyInfo(){
         if(isEmpty()){
            System.out.println("Stack is Empty.");
            return;
        }
        System.out.println("Stack is not Empty.");
        System.out.println("Stack has " + size() + " number of Elments.");
    }

    private int size(){
        return top+1;
    }

    void sizeInfo(){
        System.out.println("Size: " + size() + ".");
    }

    void display(){
        if(isEmpty()){
            System.out.println("Stack is Empty.");
            return;
        }
        System.out.print("Stack Elements: ");
        for(int i=top; i >= 0; i--){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class input1{
    public static void main(String[] args) {
        Stack_Array stack1 = new Stack_Array(5);
        stack1.pop();
        stack1.isEmptyInfo();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.display();
        stack1.isFullInfo();
        stack1.sizeInfo();
        stack1.push(6);
        stack1.pop();
        stack1.display();
        stack1.isEmptyInfo();
        stack1.isFullInfo();
    }
}
