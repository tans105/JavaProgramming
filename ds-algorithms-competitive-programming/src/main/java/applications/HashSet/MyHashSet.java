package applications.HashSet;

public class MyHashSet {
    private Bucket[] buckets;
    private static final int BUCKET_SIZE = 10;

    public MyHashSet() {
        buckets = new Bucket[BUCKET_SIZE];
        for (int i = 0; i < BUCKET_SIZE; i++) buckets[i] = new Bucket();
    }

    public void add(int key) {
        Bucket dBucket = getBucket(key);
        dBucket.addEntry(key);
    }

    public void remove(int key) {
        Bucket dBucket = getBucket(key);
        dBucket.removeEntry(key);
    }

    public boolean contains(int key) {
        Bucket dBucket = getBucket(key);
        return dBucket.contains(key);
    }

    //TODO: Implemented fair hashing algorithm
    private Bucket getBucket(int key) {
        return buckets[key % BUCKET_SIZE];
    }

    public void print() {
        for (Bucket bucket : buckets) {
            System.out.println(bucket);
        }
    }
}
