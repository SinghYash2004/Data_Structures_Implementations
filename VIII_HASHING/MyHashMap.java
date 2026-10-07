package VIII_HASHING;

public class MyHashMap {

    class HNode{
        String key;
        int value;
        HNode next;
    
        HNode(String key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private HNode[] buckets;
    private int capacity;
    private int size;

    MyHashMap(int capacity){
        this.capacity = capacity;
        buckets = new HNode[capacity];
    }

    int hash(String key){
        return Math.abs(key.hashCode())%capacity;
    }

    void put(String key, int value){
        int index = hash(key);
        HNode head = buckets[index];
        while(head!=null){
            if(head.key.equals(key)){
                head.value  = value;
                return;
            }else{
                head = head.next;
            }
        }
        HNode newNode = new HNode(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;

        if((double) size/capacity > 0.75){
            rehash();
        }
    }

    public void rehash(){
        HNode[] oldbuckets = buckets;
        size = 0;
        capacity *= 2;
        buckets = new HNode[capacity];
        for (HNode head: oldbuckets){
            while(head!=null){
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    public Integer get(String key){
        int index = hash(key);
        HNode head = buckets[index];

        while(head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public Boolean conatinsKey(String key){
        int index = hash(key);
        HNode head = buckets[index];

        while(head!=null){
            if(head.key.equals(key)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public void remove(String key){
        int index = hash(key);
        HNode current = buckets[index];
        HNode prev = null;

        while(current.next!=null){
            if(current.key.endsWith(key)){
                if(prev ==  null){
                    buckets[index] = current.next;
                }else{
                    prev.next= current.next;
                }
                size--;
                return;
            }
            prev=current;
            current= current.next;
        }
    }
}

/*
Time Complexity
Operation	            Average	         Worst
put()	                 O(1)	         O(n)
get()	                 O(1)	         O(n)
remove()	             O(1)	         O(n)
containsKey()	         O(1)	         O(n)
rehash()	             O(n)	         O(n) 
*/
