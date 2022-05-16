package applications.HashSet;

public class Entry {
    Entry next;
    int val;

    public Entry(int key) {
        this.val = key;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
