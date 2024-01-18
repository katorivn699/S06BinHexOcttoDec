/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s06binhexocttodec;

import java.util.Scanner;

/**
 * S06 Convert binary, octal and hexadecimal to decimal.
 *
 * @author Duong Nhat Anh - CE181079
 */
public class S06BinHexOcttoDec {

    /**
     * This is the main method of the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a scanner object to get user input
        Scanner sc = new Scanner(System.in);
        // Create an object of the BaseToDecimalConverter class
        BaseToDecimalConverter con = new BaseToDecimalConverter();
        // Declare a variable to store the user's choice
        int option;
        // Start a do-while loop
        do {
            // Declare variables to store the input number and the output result
            String base;
            int res;
            // Display the menu
            con.menu();
            // Get the user's choice from 1 to 4
            option = MyLib.getInteger("Please choose number(1 - 4): ", "Please type from 1 to 4! Enter again.", 1, 4);
            // Use a switch statement to handle different choices
            switch (option) {
                // If the user chooses 1, convert a binary number to decimal
                case 1:
                    con.convertBinary();
                    System.out.println();
                    break;
                // If the user chooses 2, convert an octal number to decimal
                case 2:
                    con.convertOctal();
                    System.out.println();
                    break;
                // If the user chooses 3, convert a hexadecimal number to decimal
                case 3:
                    con.convertHexadecimal();
                    System.out.println();
                    break;
                // If the user chooses 4, exit the program
                case 4:
                    // Exit the program
                    break;
            }
            // End the loop when the user chooses 4
        } while (option != 4);
    }
}
