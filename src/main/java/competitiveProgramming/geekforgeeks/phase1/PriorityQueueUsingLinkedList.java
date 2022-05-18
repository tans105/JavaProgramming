package competitiveProgramming.geekforgeeks.phase1;

public class PriorityQueueUsingLinkedList {
    private static Element head;

    public void printList() {
        Element el = head;
        while (el != null) {
            System.out.println("(Value)->" + el.value + " :: (Priority) ->" + el.priority + "\t");
            el = el.next;
        }
        System.out.println();
    }

    public void enqueue(Element newElement) {
        Element el = head;
        Element prev = null;
        if (head == null) {
            head = newElement;
            head.next = null;
        } else {
            if (head.priority < newElement.priority) {
                newElement.next = el;
                head = newElement;
                return;
            }
            while (el != null) {
                if (el.priority < newElement.priority) {
                    prev.next = newElement;
                    newElement.next = el;
                    return;
                }
                prev = el;
                el = el.next;
            }
            prev.next = newElement;
            newElement.next = null;
        }
    }

    public Element peek() {
        return head;
    }

    public void dequeue() {
        Element el = head;
        head = el.next;
    }

    public boolean contains(char c) {
        Element el = head;
        while (el != null) {
            if (el.value == c) {
                return true;
            }
            el = el.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        Element el = head;
        int count = 0;
        while (el != null) {
            count++;
            el = el.next;
        }
        return count;
    }
}

class Element {
    char value;
    int priority;
    Element next;

    Element(char value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}
