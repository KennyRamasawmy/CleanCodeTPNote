package org.example;

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

        for (int count : counts) {
            if (count == 5) return 50; // YAMS
        }

        for (int count : counts) {
            if (count == 4) return 35; // Carré
        }

        for (int count : counts) {
            if (count == 3) return 28; // Brelan
        }

        return 0;
    }
}
