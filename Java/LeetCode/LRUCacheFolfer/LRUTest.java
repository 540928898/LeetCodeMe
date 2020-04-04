package LeetCode.LRUCacheFolfer;

public class LRUTest {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
        for (int i = 0; i < 10; i++) {
            lruCache.put(i,i);
        }
        lruCache.printLruCache();
    }
}
