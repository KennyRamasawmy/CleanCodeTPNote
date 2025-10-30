package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YamsTest {

    @Test
    void ShouldReturn50() {
        int[][] throwsArray = {
                {6, 6, 6, 6, 6}
        };
        int[] expected = {50};
        assertArrayEquals(expected, Yams.scoreAll(throwsArray));
    }


    @Test
    void ShouldReturn28() {
        int[][] throwsArray = {
                {6, 6, 6, 3, 1}
        };
        int[] expected = {28};
        assertArrayEquals(expected, Yams.scoreAll(throwsArray));
    }

    @Test
    void ShouldReturn35() {
        int[][] throwsArray = {
                {6, 6, 6, 6, 1}
        };
        int[] expected = {35};
        assertArrayEquals(expected, Yams.scoreAll(throwsArray));
    }


    @Test
    void ShouldReturn30() {
        int[][] throwsArray = {
                {2, 2, 2, 5, 5}
        };
        int[] expected = {30};
        assertArrayEquals(expected, Yams.scoreAll(throwsArray));
    }


    @Test
    void ShouldReturn40() {
        int[][] throwsArray = {
                {2, 3, 4, 5, 6}
        };
        int[] expected = {40};
        assertArrayEquals(expected, Yams.scoreAll(throwsArray));
    }


    @Test
    void ShouldReturn16() {
        int[][] throwsArray = {
                {1, 2, 3, 4, 6}
        };
        int[] expected = {16}; // Somme des dés
        assertArrayEquals(expected, Yams.scoreAll(throwsArray));
    }

    @Test
    void TestAllPossibleCasesOfPoints() {
        int[][] throwsArray = {
                {6, 6, 6, 6, 6},     // YAMS → 50
                {4, 4, 4, 4, 2},     // Carré → 35
                {3, 3, 3, 1, 5},     // Brelan → 28
                {2, 2, 2, 5, 5},     // Full → 30
                {2, 3, 4, 5, 6},     // Grande suite → 40
                {1, 2, 3, 4, 6},     // Chance → 16
                {2, 2, 2, 2, 2},     // YAMS → 50
                {1, 1, 1, 1, 2},     // Carré → 35
                {5, 5, 5, 2, 2},     // Full → 30
                {1, 2, 3, 4, 5}      // Grande suite → 40
        };

        int[] expected = {
                50, // YAMS
                35, // Carré
                28, // Brelan
                30, // Full
                40, // Grande suite
                16, // Chance
                50, // YAMS
                35, // Carré
                30, // Full
                40  // Grande suite
        };

        assertArrayEquals(expected, Yams.scoreAll(throwsArray));
    }

    @Test
    void testInvalidDieValueThrowsException() {
        int[][] throwsArray = {
                {1, 2, 3, 4, 7} // 7 est invalide
        };

        assertThrows(IllegalArgumentException.class, () -> {
            Yams.scoreAll(throwsArray);
        });
    }


}