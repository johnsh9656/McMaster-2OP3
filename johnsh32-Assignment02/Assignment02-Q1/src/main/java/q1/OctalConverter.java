package q1;
import java.util.Scanner;

public class OctalConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // get user's decimal number
        System.out.print("Enter a decimal number between -1000 and 1000: ");
        int decimalNum = scanner.nextInt();

        int octalNum = convertDecimalToOctal(decimalNum);

        // return octal number
        System.out.println("Decimal: " + decimalNum + ", Octal: " + octalNum);
        
        scanner.close();
    }

    // in: decimal number, out: octal equivalent
    private static int convertDecimalToOctal(int decimal) {
        // work with positive value, remember if negative for returned value
        boolean isNegative = decimal < 0;
        decimal = Math.abs(decimal);

        int octal = 0;
        int placeValue = 1;

        // conversion process
        while (decimal > 0) {
            int remainder = decimal % 8;
            octal += remainder * placeValue;
            decimal /= 8;
            placeValue *= 10;
        }

        return isNegative ? -octal : octal;
    }
}
