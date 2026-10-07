package VII_HEAP;
/*
1. Constructor
2. isFull()
3. isEmpty()
4. size()
5. peek()
6. insert()
7. heapifyUp()
8. deleteMax()
9. heapifyDown()
10. display() */

/*
Meaning	                  Expression
Current elements	        size
Last element index	        size - 1
Empty	                    size == 0
Full	                    size == capacity
Next insertion position	    heap[size] */


public class MaxHeap {
    int[] heap;
    int capacity;
    int size;

    MaxHeap(int capacity) {
        this.capacity = capacity;
        size = 0;
        heap = new int[capacity];
    }

    boolean isFull() {
        return size == capacity;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return -1;
        }
        return heap[0];
    }

    void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap[index] > heap[parent]) {
                int temp = heap[index];
                heap[index] = heap[parent];
                heap[parent] = temp;

                index = parent;
            } else {
                break;
            }
        }
    }

    void Insert(int value) {
        if (isFull()) {
            System.out.println("Heap Overflow Condition.");
            return;
        }

        heap[size] = value;
        int current = size;
        heapifyUp(current);
        size++;
    }

    int deleteMax() {
        if (isEmpty()) {
            System.out.println("Heap Underflow");
            return -1;
        }

        int max = heap[0];

        heap[0] = heap[size - 1];
        size--;

        heapifyDown(0);

        return max;
    }

    void heapifyDown(int current) {

        while (true) {
            int left = (2 * current) + 1;
            int right = (2 * current) + 2;

            int largest = current;

            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }

            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }

            if (largest == current) {
                break;
            }

            int temp = heap[current];
            heap[current] = heap[largest];
            heap[largest] = temp;

            current = largest;
        }
    }

    void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}

class input45 {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.Insert(70);
        heap.Insert(80);
        heap.Insert(90);
        heap.Insert(340);
        heap.Insert(9);
        heap.Insert(10);
        heap.Insert(700);
        heap.Insert(87);
        heap.Insert(7180);
        heap.Insert(45);
        heap.Insert(1000);
        heap.display();
    }
}
