package q3;
import java.util.Scanner;

public class RightTriangle {
    public static void main(String[] args) {
        // initialize variables
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        // get user input
        System.out.print("Enter number of rows n (1<=n<=200): ");
        n = scanner.nextInt();

        // print triangle with nested for loop 
        for (int row=1; row<=n; row++) {
            for (int col=1; col<=row; col++) {
                System.out.print(col);
            }
            System.out.println();
        }

        scanner.close();
    }
}
