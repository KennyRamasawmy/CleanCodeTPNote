package org.example;

import java.util.Arrays;

public class Yams {

    public static int[] scoreAll(int[][] allThrows) {
        int[] scores = new int[allThrows.length];
        for (int i = 0; i < allThrows.length; i++) {
            scores[i] = score(allThrows[i]);
        }
        return scores;
    }

    public static int score(int[] dice) {

        int[] counts = new int[7]; // index 1 à 6
        for (int die : dice) {
            if (die < 1 || die > 6) throw new IllegalArgumentException("Dé invalide");
            counts[die]++;
        }

        int score = 0;

        boolean hasThree = false;
        boolean hasTwo = false;

        for (int count : counts) {
            if (count == 5) score = Math.max(score, 50); // YAMS
            else if (count == 4) score = Math.max(score, 35); // Carré
            else if (count == 3) {
                hasThree = true;
                score = Math.max(score, 28); // Brelan
            } else if (count == 2) {
                hasTwo = true;
            }
        }
        if (hasThree && hasTwo) score = Math.max(score, 30); // Full


        // Grande suite
        int[] sorted = dice.clone();
        Arrays.sort(sorted);
        if (Arrays.equals(sorted, new int[]{1, 2, 3, 4, 5}) ||
                Arrays.equals(sorted, new int[]{2, 3, 4, 5, 6})) {
            score = Math.max(score, 40);
        }

        // Chance (si aucune figure plus forte)
        int sum = Arrays.stream(dice).sum();
        score = Math.max(score, sum);

        return score;
    }
}
