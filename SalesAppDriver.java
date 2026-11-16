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

import java.io.FileNotFoundException;
import java.util.Scanner;

public class SalesAppDriver {
    /**
     * main driver method. handles almost everything.
     * @param args none
     */
    public static void main (String[] args) {
        Scanner kb = new Scanner (System.in);
        String filename;
        double[][] data = null;
        boolean invalid = true;

        System.out.println("Assignment 5: Sales Data Processing");
        System.out.println("------------------------------------");

        System.out.print("Please enter an input filename: " );
        filename = kb.nextLine();

        while (invalid) {
            try {
                data = SalesFileIO.readSalesData(filename);
                invalid = false;
            } catch (FileNotFoundException | NumberFormatException e) {
                if (e instanceof FileNotFoundException) {
                    System.out.print("Invalid filename. Please enter a new input filename: ");
                    filename = kb.nextLine();
                } else {
                    System.out.println("Malformed data detected in input file. The provided file could not be processed.");
                    printGoodbye();
                    return;
                }
            }
        }

        if (data == null) {
            System.out.println("The provided file could not be successfully processed.");
            printGoodbye();
            return;
        }

        System.out.println("Data loaded from " + filename);

        System.out.print("\n");

        System.out.print("Please enter an output filename: ");
        filename = kb.nextLine();
        invalid = true;

        while (invalid) {
            try {
                SalesFileIO.writeSummary(filename, data);
                invalid = false;
            } catch (FileNotFoundException e) {
                System.out.print("File could not be written. Please enter a new output filename: ");
                filename = kb.nextLine();
            }
        }

        System.out.printf("%nTotal sales: %.2f", SalesDataUtility.getTotal(data));
        System.out.printf("%nAverage sale: %.2f", SalesDataUtility.getAverage(data));
        System.out.printf("%nHighest sale: %.2f", SalesDataUtility.getHighestInArray(data));
        System.out.printf("%nLowest sale: %.2f", SalesDataUtility.getLowestInArray(data));

        System.out.print("\n");

        for (int i = 0; i < data.length; i++) {
            String line = "%nRow " + i + " total: %.2f";
            System.out.printf(line, SalesDataUtility.getRowTotal(data, i));
        }

        System.out.print("\n");
        System.out.println("Summary written to " + filename);

        printGoodbye();
        kb.close();
    }

    /**
     * prints the goodbye. method exists to make code marginally cleaner
     */
    public static void printGoodbye () {
        System.out.print("\nprogram written by a student, Michael Jarman");;
    }
}
