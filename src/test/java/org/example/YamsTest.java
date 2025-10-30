package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YamsTest {

    @Test
    void testSingleYamsThrow() {
        int[][] throwsArray = {
                {6, 6, 6, 6, 6}
        };
        int[] expected = {50};
        assertArrayEquals(expected, Yams.scoreAll(throwsArray));
    }


    @Test
    void testYamsthreeequal() {
        int[][] throwsArray = {
                {6, 6, 6, 0, 1}
        };
        int[] expected = {28};
        assertArrayEquals(expected, Yams.scoreAll(throwsArray));
    }

    @Test
    void testYamsfourqual() {
        int[][] throwsArray = {
                {6, 6, 6, 6, 1}
        };
        int[] expected = {35};
        assertArrayEquals(expected, Yams.scoreAll(throwsArray));
    }


    @Test
    void testFull() {
        int[][] throwsArray = {
                {2, 2, 2, 5, 5}
        };
        int[] expected = {30};
        assertArrayEquals(expected, Yams.scoreAll(throwsArray));
    }


    @Test
    void testGrandeSuite() {
        int[][] throwsArray = {
                {2, 3, 4, 5, 6}
        };
        int[] expected = {40};
        assertArrayEquals(expected, Yams.scoreAll(throwsArray));
    }


    @Test
    void testChance() {
        int[][] throwsArray = {
                {1, 2, 3, 4, 6}
        };
        int[] expected = {16}; // Somme des dés
        assertArrayEquals(expected, Yams.scoreAll(throwsArray));
    }

}