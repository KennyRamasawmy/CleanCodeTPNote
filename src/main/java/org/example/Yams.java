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
        validateDice(dice);
        int[] counts = countDiceValues(dice);
        int score = 0;

        score = Math.max(score, scoreYams(counts));
        score = Math.max(score, scoreCarre(counts));
        score = Math.max(score, scoreFull(counts));
        score = Math.max(score, scoreBrelan(counts));
        score = Math.max(score, scoreGrandeSuite(dice));
        score = Math.max(score, scoreChance(dice));

        return score;
    }

    private static void validateDice(int[] dice) {
        for (int die : dice) {
            if (die < 1 || die > 6) {
                throw new IllegalArgumentException("Dé invalide : " + die);
            }
        }
    }

    private static int[] countDiceValues(int[] dice) {
        int[] counts = new int[7]; // index 1 to 6
        for (int die : dice) {
            counts[die]++;
        }
        return counts;
    }

    private static int scoreYams(int[] counts) {
        for (int count : counts) {
            if (count == 5) return 50;
        }
        return 0;
    }

    private static int scoreCarre(int[] counts) {
        for (int count : counts) {
            if (count == 4) return 35;
        }
        return 0;
    }

    private static int scoreBrelan(int[] counts) {
        for (int count : counts) {
            if (count == 3) return 28;
        }
        return 0;
    }

    private static int scoreFull(int[] counts) {
        boolean hasThree = false;
        boolean hasTwo = false;
        for (int count : counts) {
            if (count == 3) hasThree = true;
            if (count == 2) hasTwo = true;
        }
        return (hasThree && hasTwo) ? 30 : 0;
    }

    private static int scoreGrandeSuite(int[] dice) {
        int[] sorted = dice.clone();
        Arrays.sort(sorted);
        if (Arrays.equals(sorted, new int[]{1, 2, 3, 4, 5}) ||
                Arrays.equals(sorted, new int[]{2, 3, 4, 5, 6})) {
            return 40;
        }
        return 0;
    }

    private static int scoreChance(int[] dice) {
        return Arrays.stream(dice).sum();
    }
}

