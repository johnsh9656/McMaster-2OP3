package q2;

/*
 * Harrison Johns
 * johnsh32
 * Assignment03-Q2
 * converts a user input alphanumerical phone
 * number to a numerical phone number
 */

import java.util.Scanner;

public class AlphaToNumericPhoneNumber {

    // get input (10-char alphanumerical phone #), output numerical equivalent
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter telephone number: ");
        String user = scanner.nextLine();

        String numerical_phone = alphanumericalToNumerical(user);
        
        System.out.println("The phone number for "+user+" is "+numerical_phone+".");

        scanner.close();
    }

    // converts alphanumerical phone # String to numerical
    private static String alphanumericalToNumerical(String alphaStr) {
        char[] alphanum = alphaStr.toCharArray();
        char[] numerical = alphaStr.toCharArray();

        // convert each letter to digit
        for (int i=0; i<alphaStr.length(); i++) {
            switch (alphanum[i]) {
                case 'A':
                case 'B':
                case 'C':
                    numerical[i] = '2';
                    break;
                case 'D':
                case 'E':
                case 'F':
                    numerical[i] = '3';
                    break;
                case 'G':
                case 'H':
                case 'I':
                    numerical[i] = '4';
                    break;
                case 'J':
                case 'K':
                case 'L':
                    numerical[i] = '5';
                    break;
                case 'M':
                case 'N':
                case 'O':
                    numerical[i] = '6';
                    break;
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                    numerical[i] = '7';
                    break;
                case 'T':
                case 'U':
                case 'V':
                    numerical[i] = '8';
                    break;
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    numerical[i] = '9';
                    break;
            }
        }

        String numerical_str = String.valueOf(numerical);
            
        // handle hyphens in string
        if (numerical[3] != '-') {
            numerical_str = numerical_str.substring(0,3) + '-' + numerical_str.substring(3);
        }
        if (numerical[7] != '-') {
            numerical_str = numerical_str.substring(0,7) + '-' + numerical_str.substring(7);
        }

        return numerical_str;
    }
}
