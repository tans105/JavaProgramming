package competitiveProgramming.GeekForGeeks;

public class PriorityQueueUsingLinkedList {
    private static Element head;

    public static void main(String[] args) {
        PriorityQueueUsingLinkedList pl = new PriorityQueueUsingLinkedList();
        enqueue(new Element("B", 20));
        enqueue(new Element("D", 40));
        enqueue(new Element("C", 30));
        enqueue(new Element("A", 10));
        enqueue(new Element("A1", 10));
        enqueue(new Element("D1", 40));
        printList();
        dequeue();
        printList();
    }

    private static void printList() {
        Element el = head;
        while (el != null) {
            System.out.println("(Value)->" + el.value + " :: (Priority) ->" + el.priority + "\t");
            el = el.next;
        }
        System.out.println();
    }

    private static void enqueue(Element newElement) {
        Element el = head;
        Element prev = null;
        if (head == null) {
            head = newElement;
        } else {
            if (head.priority > newElement.priority) {
                newElement.next = el;
                head = newElement;
                return;
            }
            while (el != null) {
                if (el.priority > newElement.priority) {
                    prev.next = newElement;
                    newElement.next = el;
                    return;
                }
                prev = el;
                el = el.next;
            }
            prev.next = newElement;
        }
    }

    private static String peek() {
        return head.value;
    }

    private static void dequeue() {
        Element el = head;
        head = el.next;
    }
}

class Element {
    String value;
    int priority;
    Element next;

    Element(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}
