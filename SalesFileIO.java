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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesFileIO {
    final static char SPACE = ' ';

    /**
     * read sales data from provided filename
     * @param filename filename to read from - type String
     * @return populated 2d array with sales data - type double[][]
     * @throws FileNotFoundException thrown if file doesn't exist
     */
    public static double[][] readSalesData (String filename) throws FileNotFoundException {
        File dataFile = new File(filename);
        Scanner dataReader = new Scanner(dataFile);;
        int cols = 0;

        ArrayList<double[]> doubleList = new ArrayList<>();

        while (dataReader.hasNextLine()) {
            double[] line = extractLine(dataReader.nextLine());
            if (line != null)
                doubleList.add(line);
        }

        double[][] data = new double[doubleList.size()][];

        for (int i = 0; i < doubleList.size(); i++) {
            data[i] = doubleList.get(i);
        }

        dataReader.close();

        return data;
    }

    /**
     * write summary to provided filename
     * @param filename filename to write to - type String
     * @param data 2d array with sales data - type double[][]
     * @throws FileNotFoundException unlikely to see this unless disk is full, or you're having a terrible day
     */
    public static void writeSummary (String filename, double[][] data) throws FileNotFoundException {
        File outputFile = new File(filename);
        try (PrintWriter writer = new PrintWriter(outputFile)) {
            writer.println("Assignment 5, Sales Data");

            writer.printf("%nTotal Sales: %.2f", SalesDataUtility.getTotal(data));
            writer.printf("%nAverage Sales: %.2f", SalesDataUtility.getAverage(data));
            writer.printf("%nLowest Sale: %.2f", SalesDataUtility.getLowestInArray(data));
            writer.printf("%nHighest Sale: %.2f", SalesDataUtility.getHighestInArray(data));

            writer.print("\n");

            for (int i = 0; i < data.length; i++) {
                String line = "%nRow " + i + " - Total: %.2f | ";
                writer.printf(line, SalesDataUtility.getRowTotal(data, i));
                line = "Lowest: %.2f | ";
                writer.printf(line, SalesDataUtility.getLowestInRow(data, i));
                line = "Highest: %.2f";
                writer.printf(line, SalesDataUtility.getHighestInRow(data, i));
            }

            writer.print("\n");

            int longestRow = longestRow(data);

            for (int i = 0; i < longestRow; i++) {
                String line = "%nColumn " + i + " total: %.2f";
                writer.printf(line, SalesDataUtility.getColumnTotal(data, i));
            }

            writer.print("\n\nprogram written by a student, Michael Jarman");
        }
    }

    /**
     * parses line from provided String. this does the "handling" of each line for file IO.
     * I made this method to make the code a little more readable.
     * @param line line to parse - type String
     * @return one-dimensional double array with extracted values - type double[]
     * @throws NumberFormatException if an invalid line is found, this exception is thrown
     */
    public static double[] extractLine (String line) throws NumberFormatException {
        char[] arr = line.toCharArray();
        int count = 0;
        ArrayList<String> extracted = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : arr) {
            if (c != SPACE) {
                sb.append(c);
            } else {
                if (!sb.isEmpty()) {
                    extracted.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        if (!sb.isEmpty()) {
            extracted.add(sb.toString());
        }

        double[] extractedLine = new double[extracted.size()];

        for (int i = 0; i < extracted.size(); i++) {
            try {
                extractedLine[i] = Double.parseDouble(extracted.get(i));
            } catch (NumberFormatException e) {
                throw e;
            }
        }

        return extractedLine;
    }

    /**
     * helper method to get longest row for writeSummary method
     * @param data 2d array with sales data - type double[][]
     * @return longest row - type int
     */
    public static int longestRow (double[][] data) {
        int length = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].length > length)
                    length = data[i].length;
        }
        return length;
    }
}
