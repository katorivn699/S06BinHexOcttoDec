package s06binhexocttodec;

import java.util.Scanner;

/**
 * S06 Convert binary, octal and hexadecimal to decimal.
 *
 * @author CE181079 Duong Nhat Anh
 */
public class MyLib {

    /**
     * Scanner object for user input.
     */
    public static Scanner sc = new Scanner(System.in);

    /**
     * Method to get an integer number from the user
     *
     * @param iMg Input message
     * @return An integer number.
     */
    public static int getInteger(String iMg) {
        int x; // Variable to store the input
        while (true) { // Loop until a valid input is entered
            try {
                System.out.print(iMg); // Print the input message
                x = Integer.parseInt(sc.nextLine()); // Parse the input as an integer
                return x; // Return the input
            } catch (NumberFormatException e) { // Catch any exception
                System.out.println("Input must be a number! Enter again."); // Print an error message
            }
        }
    }

    /**
     * Method to get a positive integer from the user
     *
     * @param iMg Input message
     * @return An positive number.
     */
    public static int getPositiveInteger(String iMg) {
        int x = 0; // Variable to store the input
        boolean o = false; // Flag to indicate if the input is valid
        do {
            try {
                System.out.print(iMg); // Print the input message
                x = Integer.parseInt(sc.nextLine()); // Parse the input as an integer
                if (x <= 0) { // Check if the input is positive
                    System.out.println("Number must be a positive number! Enter again"); // Print a message to indicate the condition
                    o = false; // Set the flag to false
                } else {
                    o = true; // Set the flag to true
                }
            } catch (NumberFormatException e) { // Catch any number format exception
                System.out.println("Input must be a number! Enter again"); // Print an error message
            }
        } while (!o); // Loop until the flag is true
        return x; // Return the input
    }

    /**
     * Method to get an integer from the user with a custom error message
     *
     * @param iMg Input message
     * @param eMg Error message
     * @return An integer number
     */
    public static int getInteger(String iMg, String eMg) {
        int x; // Variable to store the input
        while (true) { // Loop until a valid input is entered
            try {
                System.out.print(iMg); // Print the input message
                x = Integer.parseInt(sc.nextLine()); // Parse the input as an integer
                return x; // Return the input
            } catch (NumberFormatException e) { // Catch any exception
                System.out.println(eMg); // Print the custom error message
            }
        }
    }

    /**
     * Method to get an integer from the user with a custom error message with
     * limit.
     *
     * @param iMg Input message.
     * @param eMg Error message.
     * @param from Minimum limit.
     * @param to Maximum limit.
     * @return An Integer in limit.
     */
    public static int getInteger(String iMg, String eMg, int from, int to) {
        int x; // Variable to store the input
        while (true) { // Loop until a valid input is entered
            try {
                System.out.print(iMg); // Print the input message
                x = Integer.parseInt(sc.nextLine()); // Parse the input as an integer
                if (x >= from && x <= to) {
                    return x; // Return the input
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) { // Catch any exception
                System.out.println(eMg); // Print the custom error message
            }
        }
    }

    /**
     * Method to get a string from the user
     *
     * @param iMg Input message.
     * @return A String.
     */
    public static String getString(String iMg) {
        String x; // Variable to store the input
        boolean istype; // Flag to indicate if the input is valid
        do {
            System.out.print(iMg); // Print the input message
            x = sc.nextLine(); // Read the input as a string
            if (x.length() <= 0) { // Check if the input is empty
                System.out.println("Please type anything! don't leave it blank"); // Print a message to indicate the condition
                istype = false; // Set the flag to false
            } else {
                istype = true; // Set the flag to true
            }
        } while (!istype); // Loop until the flag is true
        return x; // Return the input
    }

    /**
     * Method to get a string from the user with a custom error message
     *
     * @param iMg Input message
     * @param eMg Error message
     * @return A String.
     */
    public static String getString(String iMg, String eMg) {
        String x; // Variable to store the input
        while (true) { // Loop until a valid input is entered
            try {
                System.out.print(iMg); // Print the input message
                x = sc.nextLine(); // Read the input as a string
                return x; // Return the input
            } catch (Exception e) { // Catch any exception
                System.out.println(eMg); // Print the custom error message
            }
        }
    }

    /**
     * Method to check if the string represents a negative number
     *
     * @param original Original string.
     * @return True if the string represents a negative number, false otherwise.
     */
    public static boolean checkNegative(String original) {
        char firstChar = original.charAt(0); // Get the first character of the string
        boolean isNegative; // Variable to store the result
        if (firstChar == '-') { // If the first character is a minus sign
            isNegative = true; // Set the result to true
        } else { // Otherwise
            isNegative = false; // Set the result to false
        }
        return isNegative; // Return the result
    }

}
