package org.example;

import java.util.Arrays;

public class Yams {

    public static int[] scoreAll(int[][] throwsList) {
        int[] scores = new int[throwsList.length];
        for (int i = 0; i < throwsList.length; i++) {
            scores[i] = score(throwsList[i]);
        }
        return scores;
    }

    public static int score(int[] dice) {

        int[] counts = new int[7];
        for (int die : dice) {
            counts[die]++;
        }


        boolean hasThree = false;
        boolean hasTwo = false;

        for (int count : counts) {
            if (count == 3) hasThree = true;
            if (count == 2) hasTwo = true;
        }

        if (hasThree && hasTwo) return 30;


        int[] sorted = dice.clone();
        Arrays.sort(sorted);

        boolean isSmallStraight = Arrays.equals(sorted, new int[]{1, 2, 3, 4, 5});
        boolean isLargeStraight = Arrays.equals(sorted, new int[]{2, 3, 4, 5, 6});

        if (isSmallStraight || isLargeStraight) return 40;

        for (int count : counts) {
            if (count == 5) return 50; // YAMS
        }

        for (int count : counts) {
            if (count == 4) return 35; // Carré
        }

        for (int count : counts) {
            if (count == 3) return 28; // Brelan
        }

        int sum = 0;
        for (int die : dice) {
            sum += die;
        }
        return sum;
    }
}
