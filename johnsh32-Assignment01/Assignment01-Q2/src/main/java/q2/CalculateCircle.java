package q2;
import java.util.Scanner;
import java.lang.Math;

public class CalculateCircle {
    public static void main(String[] args) {
        // get input
        Scanner input = new Scanner(System.in);
        double radius = input.nextDouble();

        if (radius <= 0.0 || radius > 10.0) {
            return;
        }

        // calculate area and perimeter
        double area = Math.PI * radius * radius;
        double perimeter = Math.PI * 2 * radius;

        // print values rounded to 2 sig digs after decimal
        double roundedArea = Math.round(area * 100.0) / 100.0;
        double roundedPerimeter = Math.round(perimeter * 100.0) / 100.0;
        
        System.out.printf("%.2f\n", roundedArea);
        System.out.printf("%.2f\n", roundedPerimeter);

    }
}