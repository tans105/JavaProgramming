package applications.hashset;

public class Bucket {
    private Entry head;
    private static final String NULL_TEXT = "NULL";
    private static final String SEPARATOR = "->";

    Bucket() {
        head = null;
    }

    public void addEntry(int key) {
        Entry entry = new Entry(key);
        Entry e = head;
        Entry prev = null;

        if (e == null) {
            head = entry;
        } else {
            while (e != null) {
                if(e.val == key) return;
                prev = e;
                e = e.next;
            }

            prev.next = entry;
        }
    }

    public void removeEntry(int key) {
        Entry e = head;
        Entry prev = null;

        while (e != null) {
            if (e.val == key) {
                if (prev != null) {
                    prev.next = e.next;
                } else {
                    head = e.next;
                }

                break;
            }

            prev = e;
            e = e.next;
        }
    }

    public boolean contains(int key) {
        Entry e = head;
        boolean isPresent = false;

        while (e != null) {
            if (e.val == key) {
                isPresent = true;
                break;
            }
            e = e.next;
        }

        return isPresent;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        Entry e = head;

        while (e != null) {
            builder.append(e.val);
            builder.append(SEPARATOR);
            e = e.next;
        }

        builder.append(NULL_TEXT);

        return builder.toString();
    }
}
