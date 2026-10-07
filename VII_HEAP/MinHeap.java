package VII_HEAP;

public class MinHeap {
    int[] heap;
    int capacity;
    int size;

    MinHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
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
            System.out.println("Heap is empty.");
            return -1;
        }
        return heap[0];
    }

    void insert(int value) {
        if (isFull()) {
            System.out.println("Heap Overflow.");
            return;
        }
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[index] < heap[parent]) {
                int temp = heap[index];
                heap[index] = heap[parent];
                heap[parent] = temp;
                index = parent;
            } else {
                break;
            }
        }
    }

    int deleteMin() {
        if (isEmpty()) {
            System.out.println("Heap Underflow.");
            return -1;
        }
        // maintain a variable which will store the min value
        int min = heap[0];

        // put last element to the first element's place
        heap[0] = heap[size - 1];
        size--;

        // Now heapify down condition checking
        heapifyDown(0);
        return min;
    }

    void heapifyDown(int current){
        while(true){
            int left = (current * 2) + 1;
            int right = (current * 2) + 2;
            int smallest = current;

            if(left<size && heap[smallest] > heap[left])
                smallest = left;
            if(right<size && heap[smallest]> heap[right])
                smallest = right;
            if(smallest == current){
                break;
            }

            int temp = heap[current];
            heap[current] = heap[smallest];
            heap[smallest] = temp;

            current = smallest;
        }
    }

    void display(){
        System.out.print("Heap Elements: ");
        
        for(int i = 0; i<size; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
