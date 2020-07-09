package competitiveProgramming.random;

import java.util.Scanner;

public class horseshoe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] arr = new int[4];
        int k = 0;

        while (num != 0) {
            arr[k] = num % 10;//arr[0]=last digit arr[3]=first digit
            num = num / 10;
            k++;
            
        }
            int count = 0;
            
            
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {

                    if (arr[i] == arr[j]) {
                        count++;
                    }
                }
            }

            if (count == 16) {
                System.out.println("3");
            }
            if (count == 10) {
                System.out.println("2");
            }
            if (count == 6) {
                System.out.println("1");
            }
            if (count == 4) {
                System.out.println("0");
            }
        }

    }

