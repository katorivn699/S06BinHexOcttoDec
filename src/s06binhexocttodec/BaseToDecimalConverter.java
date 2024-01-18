/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s06binhexocttodec;

/**
 * S06 Convert binary, octal and hexadecimal to decimal.
 *
 * @author Duong Nhat Anh - CE181079
 */
public class BaseToDecimalConverter {

    // This field stores the base number as a string
    private String basenumber;
    // This field stores the result as an integer
    private int res;

    /**
     * This is the default constructor that creates an empty converter
     */
    public BaseToDecimalConverter() {
    }

    /**
     * This is the parameterized constructor that creates a converter with a
     * given base number and result.
     *
     * @param basenumber original number before convert.
     * @param res result after convert.
     */
    public BaseToDecimalConverter(String basenumber, int res) {
        this.basenumber = basenumber;
        this.res = res;
    }

    /**
     * This getter method returns the base number
     *
     * @return base number before convert
     */
    public String getBasenumber() {
        return basenumber;
    }

    /**
     * This setter method sets the base number.
     *
     * @param basenumber base number before convert.
     */
    public void setBasenumber(String basenumber) {
        this.basenumber = basenumber;
    }

    /**
     * This getter method returns the result
     *
     * @return result number after convert.
     */
    public int getRes() {
        return res;
    }

    /**
     * This setter method sets the result.
     *
     * @param res set result number.
     */
    public void setRes(int res) {
        this.res = res;
    }

    /**
     * This method displays a menu of options for the user to choose from. The
     * options are to convert a number from binary, octal, or hexadecimal base
     * to decimal base, or to exit the program.
     */
    public void menu() {
        System.out.println("1. Convert Binary number to decimal number");
        System.out.println("2. Convert Octal number to decimal number");
        System.out.println("3. Convert Hexadecimal number to decimal number");
        System.out.println("4. Exit");
    }

    /**
     * This method converts a binary number to a decimal number It asks the user
     * to enter a binary number and validates it It uses the binaryToDecimal
     * method to perform the conversion It displays the result using the
     * toString method It throws an exception if the input is not a valid binary
     * number.
     */
    public void convertBinary() {
        do {
            try {
                // Get the input from the user
                basenumber = MyLib.getString("Enter binary number: ");
                // Check if the input is a valid binary number
                if (checkBase(basenumber, 2)) {
                    // Convert the binary number to decimal number
                    res = binaryToDecimal(basenumber);
                } else {
                    // Throw an exception if the input is not valid
                    throw new Exception();
                }
            } catch (Exception e) {
                // Display an error message
                System.out.println("A binary number must be '0' or '1' only! Please enter a valid binary number.");
            }
            // Repeat until the input is valid
        } while (!checkBase(basenumber, 2));
        // Display the result
        System.out.println(this);
    }

    /**
     * This method converts an octal number to a decimal number It follows the
     * same logic as the convertBinary method It uses the octalToDecimal method
     * to perform the conversion It throws an exception if the input is not a
     * valid octal number.
     */
    public void convertOctal() {
        do {
            try {
                basenumber = MyLib.getString("Enter octal number: ");
                if (checkBase(basenumber, 8)) {
                    res = octalToDecimal(basenumber);
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("A octal number must be from '0' to '7'! Please enter a valid binary number.");
            }
        } while (!checkBase(basenumber, 8));
        System.out.println(this);
    }

    /**
     * This method converts a hexadecimal number to a decimal number It follows
     * the same logic as the convertBinary method It uses the
     * hexadecimalToDecimal method to perform the conversion It throws an
     * exception if the input is not a valid hexadecimal number.
     */
    public void convertHexadecimal() {
        do {
            try {
                basenumber = MyLib.getString("Enter hexadecimal number: ");
                if (checkBase(basenumber, 16)) {
                    res = hexadecimalToDecimal(basenumber);
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("A hexadecimal number must be '0' to 'F'! Please enter a valid hexadecimal number.");
            }
        } while (!checkBase(basenumber, 16));
        System.out.println(this);
    }

    /**
     * This method returns a string representation of the result
     *
     * @return a string that shows the decimal number
     */
    @Override
    public String toString() {
        return "Decimal number is: " + res;
    }

    /**
     * This method checks if the input number is valid for a given base
     *
     * @param basenumber the input number as a string
     * @param base the base of the number system (2, 8 or 16)
     * @return true if the input number is valid, false otherwise
     */
    public boolean checkBase(String basenumber, int base) {
        // Declare a boolean variable to store the result
        boolean isOk = false;
        // Loop through each character of the input number
        for (int i = 0; i < basenumber.length(); i++) {
            // Use a switch statement to check the base
            switch (base) {
                // If the base is 2, the input number must be '0' or '1'
                case 2:
                    if (basenumber.charAt(i) != '1' && basenumber.charAt(i) != '0') {
                        isOk = false;
                        return isOk;
                    } else {
                        isOk = true;
                    }
                    break;
                // If the base is 8, the input number must be from '0' to '7'
                case 8:
                    if (basenumber.charAt(i) >= '0' && basenumber.charAt(i) <= '7') {
                        isOk = true;
                    } else {
                        isOk = false;
                        return isOk;
                    }
                    break;
                // If the base is 16, the input number must be from '0' to '9' or 'A' to 'F'
                case 16:
                    if (basenumber.charAt(i) >= '0' && basenumber.charAt(i) <= '9') {
                        isOk = true;
                    } else if (basenumber.toUpperCase().charAt(i) >= 'A' && basenumber.toUpperCase().charAt(i) <= 'F') {
                        isOk = true;
                    } else {
                        isOk = false;
                        return isOk;
                    }
                    break;
                // If the base is not 2, 8 or 16, display an error message
                default:
                    System.out.println("Please enter only 2 or 8 or 16!");
                    break;
            }
        }
        // Return the result
        return isOk;
    }

    /**
     * This method to convert a binary number to decimal number.
     *
     * @param binary a binary string number.
     * @return a decimal number.
     */
    private int binaryToDecimal(String binary) {
        // Initialize the result variable
        int dec = 0;
        // Get the length of the binary string
        int length = binary.length();
        try {
            // Loop through each character of the binary string
            for (int i = 0; i < length; i++) {
                // Get the character at position i
                char bit = binary.charAt(i);
                // Check if the character is 0 or 1
                if (bit == '0' || bit == '1') {
                    // Convert the character to an integer
                    int value = bit - '0';
                    // Calculate the power of 2 corresponding to the position of the bit
                    int power = length - i - 1;
                    // Add to the result
                    dec += value * Math.pow(2, power);
                } else {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
        }
        // Return the result
        return dec;
    }

    /**
     * This method to convert a octal number to decimal number.
     *
     * @param octal a octal string number.
     * @return a decimal number.
     */
    private int octalToDecimal(String octal) {
        // Initialize the result variable
        int dec = 0;
        // Get the length of the octal string
        int length = octal.length();
        // Loop through each character of the octal string
        for (int i = 0; i < length; i++) {
            // Get the character at position i
            char digit = octal.charAt(i);
            // Check if the character is between 0 and 7
            if (digit >= '0' && digit <= '7') {
                // Convert the character to an integer
                int value = digit - '0';
                // Calculate the power of 8 corresponding to the position of the digit
                int power = length - i - 1;
                // Add to the result
                dec += value * Math.pow(8, power);
            } else {
            }
        }
        // Return the result
        return dec;

    }

    /**
     * This method to convert a hexadecimal number to decimal number.
     *
     * @param hexadecimal a hexadecimal string number.
     * @return a decimal number.
     */
    private int hexadecimalToDecimal(String hexadecimal) {
        // Initialize the result variable
        int dec = 0;
        // Get the length of the hexadecimal string
        int length = hexadecimal.length();
        try {
            // Loop through each character of the hexadecimal string
            for (int i = 0; i < length; i++) {
                // Get the character at position i
                char digit = hexadecimal.charAt(i);
                // Initialize the value corresponding to the character
                int value = 0;
                // Check if the character is between 0 and 9
                if (digit >= '0' && digit <= '9') {
                    // Convert the character to an integer
                    value = digit - '0';
                } else if (digit >= 'A' && digit <= 'F') {
                    // If the character is between A and F, add 10 to get the value between 10 and 15
                    value = digit - 'A' + 10;
                } else if (digit >= 'a' && digit <= 'f') {
                    // If the character is between a and f, add 10 to get the value between 10 and 15
                    value = digit - 'a' + 10;
                } else {
                    // If the character is not between 0 and 9, A and F, or a and f, return error message.
                    throw new Exception();
                }
                // Calculate the power of 16 corresponding to the position of the digit
                int power = length - i - 1;
                // Add to the result
                dec += value * Math.pow(16, power);
            }
        } catch (Exception e) {
        }
        // Return the result
        return dec;
    }

}
