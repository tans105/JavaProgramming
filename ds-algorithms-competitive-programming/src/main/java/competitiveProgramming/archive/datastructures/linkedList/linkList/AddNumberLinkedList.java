package competitiveProgramming.archive.datastructures.linkedList.linkList;

//https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
public class AddNumberLinkedList {
    Node head;

    private AddNumberLinkedList(Node head) {
        this.head = head;
    }

    public static void main(String[] args) {
        Node head1 = new Node(3);
        Node head2 = new Node(4);
        AddNumberLinkedList l1 = new AddNumberLinkedList(head1);
        AddNumberLinkedList l2 = new AddNumberLinkedList(head2);
        l1.head.next = new Node(5);
        l1.head.next.next = new Node(8);
        l2.head.next = new Node(6);
        l2.head.next.next = new Node(7);
        l2.head.next.next.next = new Node(9);
        l2.head.next.next.next.next = new Node(9);
        printLinkedList(l1);
        printLinkedList(l2);
        printLinkedList(sum(l1, l2));
    }

    private static void printLinkedList(AddNumberLinkedList list) {
        Node n = list.head;
        while (n != null) {
            System.out.print(n.val + "\t");
            n = n.next;
        }
        System.out.println();
    }

    private static AddNumberLinkedList sum(AddNumberLinkedList l1, AddNumberLinkedList l2) {
        AddNumberLinkedList l3;
        Node n1 = l1.head;
        Node n2 = l2.head;
        int temp = n1.val + n2.val;
        boolean isCarry = isCarry(temp);
        if (isCarry) {
            l3 = new AddNumberLinkedList(new Node(temp - 10));
        } else {
            l3 = new AddNumberLinkedList(new Node(temp));
        }
        n1 = n1.next;
        n2 = n2.next;
        Node n3 = l3.head;
        int prevCarry = (isCarry) ? 1 : 0;
        try {
            while (n1 != null && n2 != null) {
                temp = n1.val + n2.val + prevCarry;
                isCarry = isCarry(temp);
                if (isCarry) {
                    n3.next = new Node(temp - 10);
                } else {
                    n3.next = new Node(temp);
                }
                prevCarry = (isCarry) ? 1 : 0;
                n1 = n1.next;
                n2 = n2.next;
                n3 = n3.next;
            }
            if (n1 == null) {
                appendRemainingList(n3, n2, prevCarry);
            } else {
                appendRemainingList(n3, n1, prevCarry);
            }
        } catch (Exception ignored) {

        }
        return l3;
    }

    private static void appendRemainingList(Node n3, Node n, int prevCarry) {
        while (n != null) {
            if (n.val + prevCarry == 10) {
                n3.next = new Node(0);
                prevCarry = 1;
            } else {
                n3.next = new Node(n.val + prevCarry);
                prevCarry = 0;
            }
            n3 = n3.next;
            n = n.next;
        }
        if (prevCarry == 1) {
            n3.next = new Node(1);
        }
    }

    private static boolean isCarry(int num) {
        return num > 10;
    }
}
