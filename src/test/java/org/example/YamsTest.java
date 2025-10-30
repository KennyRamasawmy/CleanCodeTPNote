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
                {6, 6, 6, 9, 8}
        };
        int[] expected = {28};
        assertArrayEquals(expected, Yams.scoreAll(throwsArray));
    }




}