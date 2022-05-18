package competitiveProgramming.leetcode.phase1.thirtyDaysLeetcodingChallenge.year_2020.september.week2;

import java.util.*;

/*
Bulls and Cows

You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.

Please note that both secret number and friend's guess may contain duplicate digits.



Example 1:

Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1, and 7.

Example 2:

Input: secret = "1123", guess = "0111"
Output: "1A1B"
Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.

Example 3:

Input: secret = "1", guess = "0"
Output: "0A0B"

Example 4:

Input: secret = "1", guess = "1"
Output: "1A0B"

 */
public class BullsAndCow {
    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
        System.out.println(getHint("1", "0"));
        System.out.println(getHint("0", "0"));
    }

    public static String getHint(String secret, String guess) {
        if (secret == null || secret.length() == 0 || guess == null || guess.length() == 0) return null;

        int bulls = 0;
        int cows = 0;

        Set<Integer> bullIndex = new HashSet<>();
        Map<Character, Integer> secretMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bullIndex.add(i);
                bulls++;
            } else {
                int count = secretMap.getOrDefault(secret.charAt(i), 0);
                secretMap.put(secret.charAt(i), count + 1);
            }
        }

        for (int i = 0; i < secret.length(); i++) {
            if (!bullIndex.contains(i)) {
                int count = guessMap.getOrDefault(guess.charAt(i), 0);
                guessMap.put(guess.charAt(i), count + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : guessMap.entrySet()) {
            if (secretMap.containsKey(entry.getKey())) {
                cows += Math.min(entry.getValue(), secretMap.get(entry.getKey()));
            }
        }


        return bulls + "A" + cows + "B";
    }
}
