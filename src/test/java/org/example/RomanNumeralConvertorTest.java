package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralConvertorTest {

    RomanNumeralConvertor RomanNumeralConvertor = new RomanNumeralConvertor();

    @Test
    void testNumber1() {
        assertEquals("I", RomanNumeralConvertor.ConvertNumber1(1));
    }


    @Test
    void testNumber2() {
        assertEquals("II", RomanNumeralConvertor.ConvertNumber1(2));
    }

    @Test
    void testNumber3() {
        assertEquals("III", RomanNumeralConvertor.ConvertNumber1(3));
    }

    @Test
    void testNumber5() {
        assertEquals("V", RomanNumeralConvertor.ConvertNumber1(5));
    }

    @Test
    void testNumber4() {
        assertEquals("IV", RomanNumeralConvertor.ConvertNumber1(4));
    }



}