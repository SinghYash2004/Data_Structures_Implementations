package VIII_HASHING;

public class MyHashSet {

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node[] buckets;
    private int capacity;
    private int size;

    public MyHashSet(int capacity) {
        this.capacity = capacity;
        buckets = new Node[capacity];
    }

    private int hash(int key) {
        return Math.abs(key) % capacity;
    }

    public boolean contains(int key) {
        int index = hash(key);
        Node current = buckets[index];
        while (current != null) {
            if (current.data == key)
                return true;
            current = current.next;
        }
        return false;
    }

    public boolean add(int key) {
        if (contains(key))
            return false;
        int index = hash(key);
        Node newNode = new Node(key);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;

        if ((double) size / capacity > 0.75)
            rehash();

        return true;
    }

    public boolean remove(int key) {
        int index = hash(key);
        Node current = buckets[index];
        Node prev = null;
        while (current != null) {
            if (current.data == key) {
                if (prev == null)
                    buckets[index] = current.next;
                else
                    prev.next = current.next;
                size--;
                return true;
            }

            prev = current;
            current = current.next;
        }

        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void rehash() {
        Node[] oldBuckets = buckets;
        capacity *= 2;
        buckets = new Node[capacity];
        size = 0;
        for (Node head : oldBuckets) {
            while (head != null) {
                add(head.data);
                head = head.next;
            }
        }
    }
}