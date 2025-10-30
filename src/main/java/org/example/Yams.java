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

        //5 equals
        if (dice[0] == dice[1] &&
                dice[1] == dice[2] &&
                dice[2] == dice[3] &&
                dice[3] == dice[4]) {
            return 50;
        }

        //four equals
        if ((dice[0] == dice[1] && dice[1] == dice[2] && dice[2] == dice[3]) ||
                (dice[1] == dice[2] && dice[2] == dice[3] && dice[3] == dice[4]) ||
                (dice[0] == dice[1] && dice[1] == dice[2] && dice[2] == dice[4]) ||
                (dice[0] == dice[1] && dice[1] == dice[3] && dice[3] == dice[4]) ||
                (dice[0] == dice[2] && dice[2] == dice[3] && dice[3] == dice[4])) {
            return 35;
        }


        //three equals
        if ((dice[0] == dice[1] && dice[1] == dice[2]) ||
                (dice[1] == dice[2] && dice[2] == dice[3]) ||
                (dice[2] == dice[3] && dice[3] == dice[4]) ||
                (dice[0] == dice[2] && dice[2] == dice[3]) ||
                (dice[0] == dice[3] && dice[3] == dice[4]) ||
                (dice[0] == dice[1] && dice[1] == dice[4]) ||
                (dice[1] == dice[3] && dice[3] == dice[4]) ||
                (dice[0] == dice[2] && dice[2] == dice[4])) {
            return 28;
        }

        return 0;
    }
}
