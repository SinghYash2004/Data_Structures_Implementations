package VII_HEAP;

//Priority Queue naya data structure nahi hai.
// Hum heap ka use karke hi priority Queue implement ka use krte ha

/*
Priority Queue ka core bas itna hai:
Highest priority wala element sabse pehle niklega.

Insert  -> heap insert
Remove  -> deleteMax/deleteMin
Peek    -> heap[0]

*/

// Java ki Java PriorityQueue default mein Min Heap hoti hai.

/*
Min Heap ka use karke  Priority Queue
PriorityQueue<Integer> pq = new PriorityQueue<>(); */

class PriorityQueue {
    private MinHeap heap;

    PriorityQueue(int capacity) {
        heap = new MinHeap(capacity);
    }

    void enqueue(int value) {
        heap.insert(value);
    }

    int dequeue() {
        return heap.deleteMin();
    }

    int peek() {
        return heap.peek();
    }

    boolean isEmpty() {
        return heap.isEmpty();
    }

    int size() {
        return heap.size();
    }
}

/*
MaxHeap ka use karke Priority Queue
PriorityQueue<Integer> pq =
        new PriorityQueue<>(Collections.reverseOrder());
        */

class PriorityQueueMax {
    MaxHeap heap;

    void enqueue(int x) {
        heap.Insert(x);
    }

    int dequeue() {
        return heap.deleteMax();
    }

    int peek() {
        return heap.peek();
    }

}