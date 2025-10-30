package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YamsTest {

    @Test
    void testYamsfiveequal() {
        int[] dice = {6, 6, 6, 6, 6};
        assertEquals(50, Yams.score(dice));
    }

    @Test
    void testYamsthreeequal() {
        int[] dice = {6, 6, 6, 2, 3};
        assertEquals(28, Yams.score(dice));
    }




}