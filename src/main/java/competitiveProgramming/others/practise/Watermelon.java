package competitiveProgramming.others.practise;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tan$
 */
public class Watermelon {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        if (sc.nextInt() / 2 % 2 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("No");
        }

    }

}
