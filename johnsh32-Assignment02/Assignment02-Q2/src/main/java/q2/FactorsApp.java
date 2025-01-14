package q2;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class FactorsApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> div_3 = new ArrayList<>();
        List<Integer> div_5 = new ArrayList<>();
        List<Integer> div_both = new ArrayList<>();

        // get  user input
        System.out.print("Enter an integer n (1<=n<=200): ");
        int n = scanner.nextInt();

        // find divisible numbers
        for (int i=1; i<=n; i++) {
            if (i%3==0 && i%5==0) {
                div_3.add(i);
                div_5.add(i);
                div_both.add(i);
            }
            else if (i%3==0) {
                div_3.add(i);
            }
            else if (i%5==0) {
                div_5.add(i);
            }
        }

        // output results
        System.out.println("Divided by 3 -> " + ListToOutput(div_3));
        System.out.println("Divided by 5 -> " + ListToOutput(div_5));
        System.out.println("Divided by 3 and 5 -> " + ListToOutput(div_both));

        scanner.close();
    }

    // takes list of integers and returns string of contents separated by commas
    private static String ListToOutput(List<Integer> list) {
        if (list.size() == 0) {
            return "None";
        }

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            str.append(list.get(i));
            if (i < list.size() - 1) {
                str.append(", ");   // Add a comma between elements
            } else {
                str.append(".");    // End with period instead of comma
            }
        }
        return str.toString();
    }
}
