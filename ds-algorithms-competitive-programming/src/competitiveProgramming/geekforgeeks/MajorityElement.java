package competitiveProgramming.geekforgeeks;

/*
The algorithm for first phase that works in O(n) is known as Moore’s Voting Algorithm. Basic idea of the algorithm is that if we cancel out each occurrence of an element e with all the other elements that are different from e then e will exist till end if it is a majority element.

findCandidate(a[], size)
1.  Initialize index and count of majority element
     maj_index = 0, count = 1
2.  Loop for i = 1 to size – 1
    (a) If a[maj_index] == a[i]
          count++
    (b) Else
        count--;
    (c) If count == 0
          maj_index = i;
          count = 1
3.  Return a[maj_index]
Above algorithm loops through each element and maintains a count of a[maj_index]. If the next element is same then increment the count, if the next element is not same then decrement the count, and if the count reaches 0 then changes the maj_index to the current element and set the count again to 1. So, the first phase of the algorithm gives us a candidate element.
In the second phase we need to check if the candidate is really a majority element. Second phase is simple and can be easily done in O(n). We just need to check if count of the candidate element is greater than n/2.

Example :
Let the array be A[] = 2, 2, 3, 5, 2, 2, 6

Initialize maj_index = 0, count = 1
Next element is 2, which is same as a[maj_index] => count = 2
Next element is 3, which is different from a[maj_index] => count = 1
Next element is 5, which is different from a[maj_index] => count = 0
Since count = 0, change candidate for majority element to 5 => maj_index = 3, count = 1
Next element is 2, which is different from a[maj_index] => count = 0
Since count = 0, change candidate for majority element to 2 => maj_index = 4
Next element is 2, which is same as a[maj_index] => count = 2
Next element is 6, which is different from a[maj_index] => count = 1
Finally candidate for majority element is 2.
First step uses Moore’s Voting Algorithm to get a candidate for majority element.

2. Check if the element obtained in step 1 is majority element or not :

printMajority (a[], size)
1.  Find the candidate for majority
2.  If candidate is majority. i.e., appears more than n/2 times.
       Print the candidate
3.  Else
       Print "No Majority Element"


 */
public class MajorityElement {
    /* Driver program to test the above functions */
    public static void main(String[] args) {
        MajorityElement majorelement = new MajorityElement();
        int a[] = new int[]{1, 3, 3, 1, 1, 1, 2, 2, 2, 2, 2};
        int size = a.length;
        majorelement.printMajority(a, size);
    }

    /* Function to print Majority Element */
    void printMajority(int a[], int size) {
        /* Find the candidate for Majority*/
        int cand = findCandidate(a, size);
        System.out.println(cand);
        /* Print the candidate if it is Majority*/
        if (isMajority(a, size, cand))
            System.out.println(" " + cand + " ");
        else
            System.out.println("No Majority Element");
    }

    /* Function to find the candidate for Majority */
    int findCandidate(int a[], int size) {
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < size; i++) {
            if (a[maj_index] == a[i])
                count++;
            else
                count--;
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }

    /* Function to check if the candidate occurs more
       than n/2 times */
    boolean isMajority(int a[], int size, int cand) {
        int i, count = 0;
        for (i = 0; i < size; i++) {
            if (a[i] == cand)
                count++;
        }
        if (count > size / 3)
            return true;
        else
            return false;
    }
}
