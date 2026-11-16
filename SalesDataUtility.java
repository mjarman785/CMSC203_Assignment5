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

public class SalesDataUtility {
    /**
     * gets array total
     * @param data 2d array with sales data - type double[][]
     * @return total of all array elements - type double
     */
    public static double getTotal (double[][] data) {
        double sum = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sum += data[i][j];
            }
        }
        return sum;
    }

    /**
     * gets array average
     * @param data 2d array with sales data - type double[][]
     * @return average of all array elements - type double
     */
    public static double getAverage(double[][] data) {
        double sum = 0;
        int counter = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sum += data[i][j];
                counter++;
            }
        }
        return (sum / counter);
    }

    /**
     * gets total of a specific row
     * @param data 2d array with sales data - type double[][]
     * @param row row to calculate total from - type int
     * @return total of selected row - type double
     */
    public static double getRowTotal (double[][] data, int row) {
        double sum = 0;
        for (int i = 0; i < data[row].length; i++) {
            sum += data[row][i];
        }
        return sum;
    }

    /**
     * gets total of a specific column
     * @param data 2d array with sales data - type double[][]
     * @param col column to calculate total from - type int
     * @return total of selected column - type double
     */
    public static double getColumnTotal (double[][] data, int col) {
        double sum = 0;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length) {
                sum += data[i][col];
            }
        }
        return sum;
    }

    /**
     * gets highest value in specific row
     * @param data 2d array with sales data - type double[][]
     * @param row row to retrieve highest value - type int
     * @return highest value of selected row - type double
     */
    public static double getHighestInRow (double[][] data, int row) {
        double highest = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > highest) {
                highest = data[row][i];
            }
        }
        return highest;
    }

    /**
     * gets lowest value in specific row
     * @param data 2d array with sales data - type double[][]
     * @param row row to retrieve lowest value - type int
     * @return lowest value of selected row - type double
     */
    public static double getLowestInRow (double[][] data, int row) {
        double lowest = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < lowest) {
                lowest = data[row][i];
            }
        }
        return lowest;
    }

    /**
     * gets highest value in array
     * @param data 2d array with sales data - type double[][]
     * @return highest value in array - type double
     */
    public static double getHighestInArray (double[][] data) {
        double highest = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] > highest) {
                    highest = data[i][j];
                }
            }
        }
        return highest;
    }

    /**
     * gets lowest value in array
     * @param data 2d array with sales data - type double[][]
     * @return lowest value in array - type double
     */
    public static double getLowestInArray (double[][] data) {
        double lowest = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] < lowest) {
                    lowest = data[i][j];
                }
            }
        }
        return lowest;
    }
}
