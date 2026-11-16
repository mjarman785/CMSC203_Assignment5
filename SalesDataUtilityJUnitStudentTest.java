/*
 * Class: CMSC203
 * Instructor: Khandan Monshi
 * Description: Assignment 5: build an application to analyze sales data
 * Due: 11/29/2026
 * Platform/compiler: Win11 26H2 build 26430.9882 / openjdk 21.0.1 (Microsoft provided)
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Michael Jarman
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class SalesDataUtilityJUnitStudentTest {
    private double[][] testSet1 = {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
    };

    private double[][] testSet2 = {
            {-1, -2},
            {-3, -4, -5},
            {-6}
    };

    private double[][] testSet3 = {
            {0},
            {-5, 10, 0},
            {5, -10}
    };

    private double[][] testSet4 = null;

    private double[][] testSet5 = {
            {},
            {5, 81, 5},
            {77, 76, 75},
            {},
            {3}
    };

    @Test
    public void testGetTotal () {
        assertEquals(45, SalesDataUtility.getTotal(testSet1), 0.001);
        assertEquals(-21, SalesDataUtility.getTotal(testSet2), 0.001);
        assertEquals(0, SalesDataUtility.getTotal(testSet3), 0.001);
        assertThrows(NullPointerException.class, () -> SalesDataUtility.getTotal(testSet4));
        assertEquals(322, SalesDataUtility.getTotal(testSet5), 0.001);
    }

    @Test
    public void testGetAverage () {
        assertEquals(5, SalesDataUtility.getAverage(testSet1), 0.001);
        assertEquals(-3.5, SalesDataUtility.getAverage(testSet2), 0.001);
        assertEquals(0, SalesDataUtility.getAverage(testSet3), 0.001);
        assertThrows(NullPointerException.class, () -> SalesDataUtility.getAverage(testSet4));
        assertEquals(46, SalesDataUtility.getAverage(testSet5), 0.001);
    }

    @Test
    public void testGetRowTotal () {
        assertEquals(6, SalesDataUtility.getRowTotal(testSet1, 0), 0.001);
        assertEquals(9, SalesDataUtility.getRowTotal(testSet1, 1), 0.001);
        assertEquals(30, SalesDataUtility.getRowTotal(testSet1, 2), 0.001);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> SalesDataUtility.getRowTotal(testSet1, 3));

        assertEquals(-3, SalesDataUtility.getRowTotal(testSet2, 0), 0.001);
        assertEquals(-12, SalesDataUtility.getRowTotal(testSet2, 1), 0.001);
        assertEquals(-6, SalesDataUtility.getRowTotal(testSet2, 2), 0.001);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> SalesDataUtility.getRowTotal(testSet2, 3));

        assertEquals(0, SalesDataUtility.getRowTotal(testSet3, 0), 0.001);
        assertEquals(5, SalesDataUtility.getRowTotal(testSet3, 1), 0.001);
        assertEquals(-5, SalesDataUtility.getRowTotal(testSet3, 2), 0.001);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> SalesDataUtility.getRowTotal(testSet3, 3));

        assertThrows(NullPointerException.class, () -> SalesDataUtility.getRowTotal(testSet4, 0));

        assertEquals(0, SalesDataUtility.getRowTotal(testSet5, 0), 0.001);
        assertEquals(91, SalesDataUtility.getRowTotal(testSet5, 1), 0.001);
        assertEquals(228, SalesDataUtility.getRowTotal(testSet5, 2), 0.001);
        assertEquals(0, SalesDataUtility.getRowTotal(testSet5, 3), 0.001);
        assertEquals(3, SalesDataUtility.getRowTotal(testSet5, 4), 0.001);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> SalesDataUtility.getRowTotal(testSet5, 5));
    }

    @Test
    public void testGetColumnTotal () {
        assertEquals(11, SalesDataUtility.getColumnTotal(testSet1, 0), 0.001);
        assertEquals(14, SalesDataUtility.getColumnTotal(testSet1, 1), 0.001);
        assertEquals(11, SalesDataUtility.getColumnTotal(testSet1, 2), 0.001);
        assertEquals(9, SalesDataUtility.getColumnTotal(testSet1, 3), 0.001);
        assertEquals(0, SalesDataUtility.getColumnTotal(testSet1, 4), 0.001);

        assertEquals(-10, SalesDataUtility.getColumnTotal(testSet2, 0), 0.001);
        assertEquals(-6, SalesDataUtility.getColumnTotal(testSet2, 1), 0.001);
        assertEquals(-5, SalesDataUtility.getColumnTotal(testSet2, 2), 0.001);
        assertEquals(0, SalesDataUtility.getColumnTotal(testSet2, 4), 0.001);

        assertEquals(0, SalesDataUtility.getColumnTotal(testSet3, 0), 0.001);
        assertEquals(0, SalesDataUtility.getColumnTotal(testSet3, 1), 0.001);
        assertEquals(0, SalesDataUtility.getColumnTotal(testSet3, 2), 0.001);
        assertEquals(0, SalesDataUtility.getColumnTotal(testSet3, 3), 0.001);

        assertThrows(NullPointerException.class, () -> SalesDataUtility.getColumnTotal(testSet4, 0));

        assertEquals(85, SalesDataUtility.getColumnTotal(testSet5, 0), 0.001);
        assertEquals(157, SalesDataUtility.getColumnTotal(testSet5, 1), 0.001);
        assertEquals(80, SalesDataUtility.getColumnTotal(testSet5, 2), 0.001);
        assertEquals(0, SalesDataUtility.getColumnTotal(testSet5, 3), 0.001);
    }

    @Test
    public void testHighestInRow () {
        assertEquals(3, SalesDataUtility.getHighestInRow(testSet1, 0), 0.001);
        assertEquals(5, SalesDataUtility.getHighestInRow(testSet1, 1), 0.001);
        assertEquals(9, SalesDataUtility.getHighestInRow(testSet1, 2), 0.001);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> SalesDataUtility.getHighestInRow(testSet1, 3));

        assertEquals(-1, SalesDataUtility.getHighestInRow(testSet2, 0), 0.001);
        assertEquals(-3, SalesDataUtility.getHighestInRow(testSet2, 1), 0.001);
        assertEquals(-6, SalesDataUtility.getHighestInRow(testSet2, 2), 0.001);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> SalesDataUtility.getHighestInRow(testSet2, 3));

        assertEquals(0, SalesDataUtility.getHighestInRow(testSet3, 0), 0.001);
        assertEquals(10, SalesDataUtility.getHighestInRow(testSet3, 1), 0.001);
        assertEquals(5, SalesDataUtility.getHighestInRow(testSet3, 2), 0.001);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> SalesDataUtility.getHighestInRow(testSet3, 3));

        assertThrows(NullPointerException.class, () -> SalesDataUtility.getHighestInRow(testSet4, 0));

        assertEquals(Double.NEGATIVE_INFINITY, SalesDataUtility.getHighestInRow(testSet5, 0), 0.001);
        assertEquals(81, SalesDataUtility.getHighestInRow(testSet5, 1), 0.001);
        assertEquals(77, SalesDataUtility.getHighestInRow(testSet5, 2), 0.001);
        assertEquals(Double.NEGATIVE_INFINITY, SalesDataUtility.getHighestInRow(testSet5, 3), 0.001);
        assertEquals(3, SalesDataUtility.getHighestInRow(testSet5, 4), 0.001);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> SalesDataUtility.getHighestInRow(testSet5, 5));
    }

    @Test
    public void testLowestInRow () {
        assertEquals(1, SalesDataUtility.getLowestInRow(testSet1, 0), 0.001);
        assertEquals(4, SalesDataUtility.getLowestInRow(testSet1, 1), 0.001);
        assertEquals(6, SalesDataUtility.getLowestInRow(testSet1, 2), 0.001);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> SalesDataUtility.getLowestInRow(testSet1, 3));

        assertEquals(-2, SalesDataUtility.getLowestInRow(testSet2, 0), 0.001);
        assertEquals(-5, SalesDataUtility.getLowestInRow(testSet2, 1), 0.001);
        assertEquals(-6, SalesDataUtility.getLowestInRow(testSet2, 2), 0.001);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> SalesDataUtility.getLowestInRow(testSet2, 3));

        assertEquals(0, SalesDataUtility.getLowestInRow(testSet3, 0), 0.001);
        assertEquals(-5, SalesDataUtility.getLowestInRow(testSet3, 1), 0.001);
        assertEquals(-10, SalesDataUtility.getLowestInRow(testSet3, 2), 0.001);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> SalesDataUtility.getLowestInRow(testSet3, 3));

        assertThrows(NullPointerException.class, () -> SalesDataUtility.getLowestInRow(testSet4, 0));

        assertEquals(Double.POSITIVE_INFINITY, SalesDataUtility.getLowestInRow(testSet5, 0), 0.001);
        assertEquals(5, SalesDataUtility.getLowestInRow(testSet5, 1), 0.001);
        assertEquals(75, SalesDataUtility.getLowestInRow(testSet5, 2), 0.001);
        assertEquals(Double.POSITIVE_INFINITY, SalesDataUtility.getLowestInRow(testSet5, 3), 0.001);
        assertEquals(3, SalesDataUtility.getLowestInRow(testSet5, 4), 0.001);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> SalesDataUtility.getLowestInRow(testSet5, 5));
    }

    @Test
    public void getHighestInArray () {
        assertEquals(9, SalesDataUtility.getHighestInArray(testSet1), 0.001);
        assertEquals(-1, SalesDataUtility.getHighestInArray(testSet2), 0.001);
        assertEquals(10, SalesDataUtility.getHighestInArray(testSet3), 0.001);
        assertThrows(NullPointerException.class, () -> SalesDataUtility.getHighestInArray(testSet4));
        assertEquals(81, SalesDataUtility.getHighestInArray(testSet5), 0.001);
    }

    @Test
    public void getLowestInArray () {
        assertEquals(1, SalesDataUtility.getLowestInArray(testSet1), 0.001);
        assertEquals(-6, SalesDataUtility.getLowestInArray(testSet2), 0.001);
        assertEquals(-10, SalesDataUtility.getLowestInArray(testSet3), 0.001);
        assertThrows(NullPointerException.class, () -> SalesDataUtility.getLowestInArray(testSet4));
        assertEquals(3, SalesDataUtility.getLowestInArray(testSet5), 0.001);
    }
}
