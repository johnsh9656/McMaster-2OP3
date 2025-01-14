package q1;

/*
 * Harrison Johns
 * johnsh32
 * Assignment03-Q1
 * gets user input for quadratic coefficients and
 * prints the roots to the corresponding quadratic
 */

import java.lang.Math;
import java.util.Scanner;

public class SolveQuadratic {
    
    // gets user input for quadratic coefficients and prints roots
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input
        System.out.println("ax^2 + bx + c = 0");
        System.out.print("a = ");
        double a = scanner.nextDouble();
        System.out.print("b = ");
        double b = scanner.nextDouble();
        System.out.print("c = ");
        double c = scanner.nextDouble();

        // output
        System.out.println(quadratic(a, b, c));

        scanner.close();
    }

    // returns solution to quadratic as String
    private static String quadratic(double a, double b, double c) {
        // get # roots
        try {
            double discriminant = b*b - 4*a*c;

            if (discriminant < 0 || a == 0) {
                return "The equation has no real roots.";
            } else if (discriminant == 0) {
                double root = (-b)/(2*a);
                String unformatted = "For a="+a+", b="+b+", c="+c+", the root is %.2f";
                return String.format(unformatted, root);
            } else {
                double[] roots = {0.0,0.0};

                roots[0] = (-b + Math.sqrt(discriminant))/(2*a);
                roots[1] = (-b - Math.sqrt(discriminant))/(2*a);

                // round to 2 decimal places
                double[] rounded_roots = {Math.round(roots[0]*100.0)/100.0, Math.round(roots[1]*100.0)/100.0};

                String unformatted = "For a="+a+", b="+b+" and c="+c+", the roots are %.2f and %.2f";
                return String.format(unformatted, rounded_roots[0], rounded_roots[1]);
            }
        } catch (Exception e) {
            return e.getMessage();
        }

    }
}