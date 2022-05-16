package competitiveProgramming.others.practise;

import java.util.Scanner;

public class Boygirl {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int count = 0;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if(arr[s.charAt(i)-'a'] == 0){
                arr[s.charAt(i)-'a']++;
                count++;
            }
//            if (s.charAt(i) == 'a' && arr[25] != 1) {
//                count++;
//                arr[25]=1;
//            }
//            if (s.charAt(i) == 'b' && arr[0] != 1) {
//                count++;
//                arr[0] = 1;
//            }
//            if (s.charAt(i) == 'c' && arr[1] != 1) {
//                count++;
//                arr[1] = 1;
//            }
//            if (s.charAt(i) == 'd' && arr[2] != 1) {
//                count++;
//                arr[2] = 1;
//            }
//            if (s.charAt(i) == 'e' && arr[3] != 1) {
//                count++;
//                arr[3] = 1;
//            }
//            if (s.charAt(i) == 'f' && arr[4] != 1) {
//                count++;
//                arr[4] = 1;
//            }
//            if (s.charAt(i) == 'g' && arr[5] != 1) {
//                count++;
//                arr[5] = 1;
//            }
//            if (s.charAt(i) == 'h' && arr[6] != 1) {
//                count++;
//                arr[6] = 1;
//            }
//            if (s.charAt(i) == 'i' && arr[7] != 1) {
//                count++;
//                arr[7] = 1;
//            }
//            if (s.charAt(i) == 'j' && arr[8] != 1) {
//                count++;
//                arr[8] = 1;
//            }
//            if (s.charAt(i) == 'k' && arr[9] != 1) {
//                count++;
//                arr[9] = 1;
//            }
//            if (s.charAt(i) == 'l' && arr[10] != 1) {
//                count++;
//                arr[10] = 1;
//            }
//            if (s.charAt(i) == 'm' && arr[11] != 1) {
//                count++;
//                arr[11] = 1;
//            }
//            if (s.charAt(i) == 'n' && arr[12] != 1) {
//                count++;
//                arr[12] = 1;
//            }
//
//            if (s.charAt(i) == 'o' && arr[13] != 1) {
//                count++;
//                arr[13] = 1;
//            }
//            if (s.charAt(i) == 'p' && arr[14] != 1) {
//                count++;
//                arr[14] = 1;
//            }
//            if (s.charAt(i) == 'q' && arr[15] != 1) {
//                count++;
//                arr[15] = 1;
//            }
//            if (s.charAt(i) == 'r' && arr[16] != 1) {
//                count++;
//                arr[16] = 1;
//            }
//            if (s.charAt(i) == 's' && arr[17] != 1) {
//                count++;
//                arr[17] = 1;
//            }
//            if (s.charAt(i) == 't' && arr[18] != 1) {
//                count++;
//                arr[18] = 1;
//            }
//            if (s.charAt(i) == 'u' && arr[19] != 1) {
//                count++;
//                arr[19] = 1;
//            }
//            if (s.charAt(i) == 'v' && arr[20] != 1) {
//                count++;
//                arr[20] = 1;
//            }
//            if (s.charAt(i) == 'w' && arr[21] != 1) {
//                count++;
//                arr[21] = 1;
//            }
//            if (s.charAt(i) == 'x' && arr[22] != 1) {
//                count++;
//                arr[22] = 1;
//            }
//            if (s.charAt(i) == 'y' && arr[23] != 1) {
//                count++;
//                arr[23] = 1;
//            }
//            if (s.charAt(i) == 'z' && arr[24] != 1) {
//                count++;
//                arr[24] = 1;
//            }
            
     


        }
        System.out.println(count);
        if(count%2==0)
            System.out.println("CHAT WITH HER!");
        else
            System.out.println("IGNORE HIM!");
        
    }
}
