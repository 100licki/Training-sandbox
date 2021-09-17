package com.stolicki.unitTests.challenges;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertArrayEquals;

public class UtilitiesTest {

    private Utilities utilities;

    @Before
    public void setup() {
        utilities = new Utilities();
    }

    @Test
    public void everyNthChar() {
        char[] output = utilities.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 2);
        assertArrayEquals(new char[]{'e', 'l'}, output);
    }

    @Test
    public void everyNthChar_nGreaterThanLength() {
        char[] output = utilities.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 6);
        assertArrayEquals(new char[]{'h', 'e', 'l', 'l', 'o'}, output);
    }

    @Test
    public void removePairs_firstExample() {
        String actual = utilities.removePairs("AABCDDEFF");
        assertEquals("ABCDEF", actual);
    }

    @Test
    public void removePairs_secondExample() {
        String actual = utilities.removePairs("ABCCABDEEF");
        assertEquals("ABCABDEF", actual);
    }

    @Test
    public void removePairs_thirdExample() {
        String actual = utilities.removePairs("AAAAAABBBBCCCC");
        assertEquals("ABC", actual);
    }

    @Test
    public void removePairs_oneChar() {
        String actual = utilities.removePairs("A");
        assertEquals("A", actual);
    }

    @Test
    public void removePairs_null() {
        String actual = utilities.removePairs(null);
        assertNull(actual);
    }

    @Test
    public void converter() {
        assertEquals(300, utilities.converter(10, 5));
    }

    @Test(expected = ArithmeticException.class)
    public void converter_divideByZeroException() {
        utilities.converter(10, 0);
        fail("ArithmeticException expected");
    }

    @Test
    public void nullIfOddLength_even() {
        String source = "Helo";
        assertEquals("Helo", utilities.nullIfOddLength(source));
    }

    @Test
    public void nullIfOddLength_odd() {
        String source = "Hello";
        assertNull(utilities.nullIfOddLength(source));
    }

    @Test
    public void nullIfOddLength_isNull() {
        String source = null;
        assertNull(utilities.nullIfOddLength(source));
    }

}