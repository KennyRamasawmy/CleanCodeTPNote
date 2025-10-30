package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralConvertorTest {

    RomanNumeralConvertor RomanNumeralConvertor = new RomanNumeralConvertor();

    @Test
    void testNumber1() {
        assertEquals("I", RomanNumeralConvertor.ConvertNumber1(1));
    }




}