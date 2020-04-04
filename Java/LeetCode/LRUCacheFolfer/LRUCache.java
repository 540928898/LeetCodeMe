package LeetCode.LRUCacheFolfer;

import java.util.HashMap;

public class LRUCache {
    class DLinkedNode{
        int key;
        int vaule;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key, int vaule) {
            this.key = key;
            this.vaule = vaule;
            prev = null;
            next = null;
        }
    }
    DLinkedNode head = new DLinkedNode();
    DLinkedNode tail = new DLinkedNode();

    int size;
    int capacity;
    HashMap<Integer, DLinkedNode> hashMap = new HashMap();

    public void addHead(int key,int value) {
        DLinkedNode node = new DLinkedNode(key,value);
        DLinkedNode headNext = head.next;
        node.next = headNext;
        head.next = node;
        headNext.prev = node;
        node.prev = head;
        hashMap.put(key,node);
    }
    public void addLast(int key,int value){
        DLinkedNode node = new DLinkedNode(key,value);
        DLinkedNode tailPre = tail.prev;
        node.next = tail;
        tailPre.next = node;
        tail.prev = node;
        node.prev = tailPre;
        hashMap.put(key,node);

    }
    public void removeLast(){
        hashMap.remove(tail.key);
        tail = tail.prev;
        tail.next = null;
    }
    public void moveToHead(int key){
        DLinkedNode needToMove = hashMap.get(key);
        DLinkedNode pre = needToMove.prev;
        DLinkedNode next = needToMove.next;
        needToMove.next = head.next;
        head.next = needToMove;
        head.next.next.prev = needToMove;
        needToMove.prev = head;
        pre.next=next;
        next.prev=pre;
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head.next = tail;
        this.tail.prev = head;

    }

    public int get(int key) {
        DLinkedNode temp = hashMap.get(key);
        if (temp == null) {
            return -1;
        }
        moveToHead(key);
        return hashMap.get(key).vaule;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            if(hashMap.get(key).vaule != value) hashMap.get(key).vaule = value;
            get(key);
        }
        else{
            if (this.size < this.capacity) {
                addHead(key,value);
                this.size ++;
            }
            else{
                removeLast();
                addHead(key,value);
            }
        }
    }
    public void printLruCache(){
        DLinkedNode temp = head.next;
        while (temp != tail){
            System.out.print(temp.vaule+" ");
            temp = temp.next;
        }
//        System.out.println(temp.vaule);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
//        lruCache.printLruCache();
        for (int i = 0; i < 30; i++) {
            lruCache.put(i,i);
        }

        lruCache.printLruCache();
        System.out.println("\n\r");
        lruCache.get(20);
        lruCache.get(12);
        lruCache.put(26,5);
        lruCache.printLruCache();

    }
}
