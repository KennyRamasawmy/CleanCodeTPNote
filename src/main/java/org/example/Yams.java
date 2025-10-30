package org.example;

import java.util.*;

public class Yams {

    private static final Map<String, Integer> FIGURE_SCORES = Map.of(
            "YAMS", 50,
            "Carré", 35,
            "Full", 30,
            "Brelan", 28,
            "Grande suite", 40
            // Chance est géré à part
    );

    public static int[] scoreAll(int[][] allThrows) {
        int[] scores = new int[allThrows.length];
        Set<String> usedFigures = new HashSet<>();

        for (int i = 0; i < allThrows.length; i++) {
            String figure = selectFigure(allThrows[i], usedFigures);
            usedFigures.add(figure);
            scores[i] = getScoreForFigure(figure, allThrows[i]);
        }

        return scores;
    }

    private static String selectFigure(int[] dice, Set<String> usedFigures) {
        validateDice(dice);
        int[] counts = countDiceValues(dice);
        Map<String, Integer> candidates = new HashMap<>();

        if (!usedFigures.contains("YAMS") && scoreYams(counts)) candidates.put("YAMS", FIGURE_SCORES.get("YAMS"));
        if (!usedFigures.contains("Carré") && scoreCarre(counts)) candidates.put("Carré", FIGURE_SCORES.get("Carré"));
        if (!usedFigures.contains("Full") && scoreFull(counts)) candidates.put("Full", FIGURE_SCORES.get("Full"));
        if (!usedFigures.contains("Brelan") && scoreBrelan(counts)) candidates.put("Brelan", FIGURE_SCORES.get("Brelan"));
        if (!usedFigures.contains("Grande suite") && scoreGrandeSuite(dice)) candidates.put("Grande suite", FIGURE_SCORES.get("Grande suite"));

        if (candidates.isEmpty()) return "Chance";

        return Collections.max(candidates.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static int getScoreForFigure(String figure, int[] dice) {
        switch (figure) {
            case "YAMS": return 50;
            case "Carré": return 35;
            case "Full": return 30;
            case "Brelan": return 28;
            case "Grande suite": return 40;
            case "Chance": return scoreChance(dice);
            default: throw new IllegalArgumentException("Figure inconnue : " + figure);
        }
    }

    private static void validateDice(int[] dice) {
        for (int die : dice) {
            if (die < 1 || die > 6) {
                throw new IllegalArgumentException("Dé invalide : " + die);
            }
        }
    }

    private static int[] countDiceValues(int[] dice) {
        int[] counts = new int[7]; // index 1 à 6
        for (int die : dice) {
            counts[die]++;
        }
        return counts;
    }

    private static boolean scoreYams(int[] counts) {
        for (int count : counts) {
            if (count == 5) return true;
        }
        return false;
    }

    private static boolean scoreCarre(int[] counts) {
        for (int count : counts) {
            if (count == 4) return true;
        }
        return false;
    }

    private static boolean scoreBrelan(int[] counts) {
        for (int count : counts) {
            if (count == 3) return true;
        }
        return false;
    }

    private static boolean scoreFull(int[] counts) {
        boolean hasThree = false;
        boolean hasTwo = false;
        for (int count : counts) {
            if (count == 3) hasThree = true;
            if (count == 2) hasTwo = true;
        }
        return hasThree && hasTwo;
    }

    private static boolean scoreGrandeSuite(int[] dice) {
        int[] sorted = dice.clone();
        Arrays.sort(sorted);
        return Arrays.equals(sorted, new int[]{1, 2, 3, 4, 5}) ||
                Arrays.equals(sorted, new int[]{2, 3, 4, 5, 6});
    }

    private static int scoreChance(int[] dice) {
        return Arrays.stream(dice).sum();
    }
}
