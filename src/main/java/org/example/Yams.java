package org.example;

public class Yams {

    public static int score(int[] dice) {

        if (dice[0] == dice[1] &&
                dice[1] == dice[2] &&
                dice[2] == dice[3] &&
                dice[3] == dice[4]) {
            return 50;
        }

        return 0;
    }
}
