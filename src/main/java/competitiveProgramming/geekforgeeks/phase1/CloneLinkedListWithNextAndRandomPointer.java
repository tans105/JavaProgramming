package competitiveProgramming.geekforgeeks.phase1;

/*
https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/

Clone a linked list with next and random pointer | Set 1
You are given a Double Link List with one pointer of each node pointing to the next node just like in a single link list. The second pointer however CAN point to any node in the list and not just the previous node. Now write a program in O(n) time to duplicate this list. That is, write a program which will create a copy of this list.
 */
public class CloneLinkedListWithNextAndRandomPointer {
    public static void main(String[] args) {
        CustomNode start = new CustomNode(1);
        start.next = new CustomNode(2);
        start.next.next = new CustomNode(3);
        start.next.next.next = new CustomNode(4);
        start.next.next.next.next = new CustomNode(5);

        start.random = start.next.next;
        start.next.random = start;
        start.next.next.random = start.next.next.next.next;
        start.next.next.next.random = start.next.next.next.next;
        start.next.next.next.next.random = start.next;

        System.out.println("Original list : ");
        print(start);

        System.out.println("Cloned list : ");
        CustomNode clonedList = clone(start);
        print(clonedList);
    }

    private static CustomNode clone(CustomNode original) {
        CustomNode curr = original, temp;

        while (curr != null) {
            temp = curr.next;

            curr.next = new CustomNode(curr.data);
            curr.next.next = temp;
            curr = temp;
        }

        curr = original;

        while (curr != null) {
            curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        curr = original;
        CustomNode clone = curr.next;
        CustomNode cloneRef = clone;

        while (curr.next.next != null) {
            temp = curr.next.next;
            clone.next = temp.next;
            curr.next = temp;
            curr = temp;
            clone = clone.next;
        }

        return cloneRef;
    }

    static class CustomNode {
        public CustomNode next;
        public CustomNode random;
        int data;

        public CustomNode(int val) {
            this.data = val;
            next = null;
            random = null;
        }

        @Override
        public String toString() {
            return "data = " + data;
        }
    }

    static void print(CustomNode start) {
        CustomNode ptr = start;
        while (ptr != null) {
            System.out.println("Data = " + ptr.data +
                    ", Random = " + ptr.random.data);
            ptr = ptr.next;
        }
    }
}
