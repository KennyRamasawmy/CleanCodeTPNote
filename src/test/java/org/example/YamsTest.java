package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YamsTest {

    @Test
    void testYams() {
        int[] dice = {6, 6, 6, 6, 6};
        assertEquals(50, Yams.score(dice));
    }

}