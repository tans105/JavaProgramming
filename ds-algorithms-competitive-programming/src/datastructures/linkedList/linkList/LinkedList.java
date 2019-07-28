package datastructures.linkedList.linkList;

import java.util.ArrayList;
import java.util.Stack;

public class LinkedList {
    public static Node head;

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        ll.head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        append(new Node(5));
        prepend(new Node(6));
        prepend(new Node(7));
        append(new Node(8));
//		delete(8);
//		delete(5);
//		delete(1);
//		reverseListIterative	();
//		reverseLinkListRecursive(head, null);
//		System.out.println(lengthOfLLRecursives(head));
//		System.out.println(searchElement(head, 7));
//		printMiddleElement();
//		countNumberOfTimesIntOccorsIterative(5);
//		System.out.println(countNumberOfTimesIntOccorsRecursive(head,5));
//		append(n3);
//		System.out.println(detectLoopFloyd());
//		isPalindrome();
//		append(n3);
//		lengthOfLoop();
//		append(new Node(8));
//		prepend(new Node(1));
//		removeDuplicateFromLinkedList();
        /**
         * 7 6 1 2 3 4 5 8
         */
        printLL();
//		swapNodes(5, 8);
//		pairWiseSwapApproach1();
//		pairWiseSwapApproach2();
        moveLastElementToFirst();
    }

    public static void reverseListIterative() {
        Node n = head;
        Node temp = null;
        Node prev = null;
        while (n != null) {
            temp = n.next;
            if (n == head) {
                n.next = null;
            } else {
                n.next = prev;
            }
            prev = n;
            n = temp;
        }
        head = prev;
    }

    public static void reverseLinkListRecursive(Node curr, Node prev) {
        if (curr.next == null) {
            head = curr;
            curr.next = prev;
            return;
        }
        Node temp = curr.next;
        curr.next = prev;
        reverseLinkListRecursive(temp, curr);
    }

    public static void printLL() {
        Node n = head;
        while (n != null) {
            System.out.print(n.val + "\t");
            n = n.next;
        }
        System.out.println();
    }

    public static void append(Node val) {
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = val;
    }

    public static void prepend(Node val) {
        val.next = head;
        head = val;
    }

    public static void delete(int val) {
        Node n = head;
        if (n.val == val) {
            Node next = n.next;
            n.next = null;
            head = next;
            printLL();
            return;
        }
        Node prev = null;
        while (n.val != val) {
            prev = n;
            n = n.next;
        }
        // n is now current
        Node newNode = n.next;
        n.next = null;
        prev.next = newNode;
    }

    public static int lengthOfLLRecursives(Node n) {
        if (n == null) {
            return 0;
        }
        return lengthOfLLRecursives(n.next) + 1;
    }

    public static boolean searchElement(Node n, int val) {
        if (n.val == val) {
            return true;
        }
        if (n.next == null) {
            return false;
        }
        return searchElement(n.next, val);
    }

    public static void printMiddleElement() {
        Node singleStep = head;
        Node twoStep = head;
        while (twoStep != null && twoStep.next != null) {
            singleStep = singleStep.next;
            twoStep = twoStep.next.next;
        }
        System.out.println(singleStep.val);
    }

    public static void countNumberOfTimesIntOccorsIterative(int val) {
        Node n = head;
        int count = 0;
        while (n != null) {
            if (n.val == val) {
                count++;
            }
            n = n.next;
        }
        System.out.println(count);
    }

    public static int countNumberOfTimesIntOccorsRecursive(Node n, int val) {
        if (n == null) {
            return 0;
        }
        if (n.val == val) {
            return countNumberOfTimesIntOccorsRecursive(n.next, val) + 1;
        } else {
            return countNumberOfTimesIntOccorsRecursive(n.next, val);
        }
    }

    private static boolean detectLoop() {
        Node n = head;
        ArrayList<Node> nodes = new ArrayList<Node>();
        boolean isLoop = false;
        while (n != null) {
            if (nodes.contains(n)) {
                isLoop = true;
                break;
            }
            nodes.add(n);
            n = n.next;
        }
        return isLoop;
    }

    public static boolean detectLoopFloyd() {
        Node singly = head;
        Node doubly = head;
        boolean isLoop = false;
        while (singly != null && doubly != null && doubly.next != null) {
            singly = singly.next;
            doubly = doubly.next.next;
            if (singly == doubly) {
                isLoop = true;
                break;
            }
        }
        return isLoop;
    }

    public static void isPalindrome() {
        Node n = head;
        Stack<Node> stack = new Stack<Node>();
        while (n != null) {
            stack.push(n);
            n = n.next;
        }
        n = head;
        Node temp = null;
        boolean isPalindrome = true;
        while (!stack.isEmpty()) {
            temp = stack.pop();
            if (temp.val != n.val) {
                isPalindrome = false;
                break;
            }
            n = n.next;
        }

        System.out.println("Is Palindrome: " + isPalindrome);
    }

    public static void lengthOfLoop() {
        if (detectLoop()) {
            Node n = head;
            int countTillLoopDetected = 0;
            Node detectedIntersectedLoop = null;
            ArrayList<Node> nodes = new ArrayList<Node>();
            while (n != null) {
                countTillLoopDetected++;
                if (nodes.contains(n)) {
                    detectedIntersectedLoop = n;
                    break;
                }
                nodes.add(n);
                n = n.next;
            }

            int count = 0;
            n = head;
            while (n != detectedIntersectedLoop) {
                count++;
                n = n.next;
            }
            System.out.println(countTillLoopDetected - count);
        } else {
            System.out.println("No Loop detected");
        }
    }

    public static void removeDuplicateFromLinkedList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> duplicateIndexes = new ArrayList<Integer>();
        Node n = head;
        while (n != null) {
            if (list.contains(n.val)) {
                duplicateIndexes.add(n.val);
            } else {
                list.add(n.val);
            }
            n = n.next;
        }
        for (int i = 0; i < duplicateIndexes.size(); i++) {
            delete(duplicateIndexes.get(i));
        }
        printLL();
    }

    public static void swapNodes(int x, int y) {
        Node prevX = null, nextX = null, prevY = null, nextY = null, X = null, Y = null;
        Node n = head;
        Node prev = null;
        while (n != null) {
            if (n.val == x) {
                X = n;
                prevX = prev;
                nextX = n.next;
            }
            if (n.val == y) {
                Y = n;
                prevY = prev;
                nextY = n.next;
            }
            prev = n;
            n = n.next;
        }
//		System.out.println(prevX.val+" "+X.val+" "+nextX.val);
//		System.out.println(prevY.val+" "+Y.val+" "+nextY.val);

        if (prevX == null) { // x is head
            head = Y;
        } else {
            prevX.next = Y;
        }

        if (nextX == Y) {
            Y.next = X;
            X.next = nextY;
        } else {
            Y.next = nextX;
            prevY.next = X;
        }
        X.next = nextY;
    }

    public static void pairWiseSwapApproach1() {
        Node n = head;
        Node node1 = null;
        Node node2 = null;
        while (n != null && n.next != null) {
            node1 = n;
            node2 = n.next;
            n = n.next.next;
            swapNodes(node1.val, node2.val);
        }
        printLL();
    }

    public static void pairWiseSwapApproach2() {
        Node n = head;
        Node node1 = null;
        Node node2 = null;
        Node nextNode = null;
        Node prevNode = null;
        while (n != null && n.next != null) {
            node1 = n;
            node2 = n.next;
            nextNode = node2.next;
            n = n.next.next;
            if (node1 == head) {
                head = node2;
                node2.next = node1;
                node1.next = nextNode;
            } else {
                prevNode.next = node2;
                node2.next = node1;
                node1.next = nextNode;
            }
            prevNode = node1;
        }
        printLL();
    }

    public static void moveLastElementToFirst() {
        Node n = head;
        Node nCopy = head;
        Node secondElement = n.next;
        while (n.next.next != null) {
            n = n.next;
        }
        Node temp = n.next;
        n.next = nCopy;
        n = n.next;
        n.next = null;
        temp.next = secondElement;
        head = temp;
        printLL();
    }


}
