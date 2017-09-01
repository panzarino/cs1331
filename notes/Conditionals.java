import java.util.Scanner;

public class Conditionals {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int num;
        do {
            System.out.print("Enter an integer: ");
            num = keyboard.nextInt();
        } while (num < 1);

        String favorites = (num % 2 == 0) ? "Georgia Tech" : "U[sic]GA";

        if ((num % 2) == 0) {
            System.out.printf("%d is even.%n", num);
        } else {
            System.out.printf("%d is odd.%n", num);
        }

        // Boolean expressions
        boolean numIsEven = (num % 2) == 0;

        // Notice the use of {} even for single statements -
        // - good idea always to use {}
        if (numIsEven) {
            System.out.println("I like even numbers.");
        } else {
            System.out.println("I'm ambivalent about odd numbers.");
        }

        // The if-else statements above can be combined using blocks
        if (numIsEven) {
            System.out.printf("%d is even.%n", num);
            System.out.println("I like even numbers.");
        } else {
            System.out.printf("%d is odd.%n", num);
            System.out.println("I'm ambivalent about odd numbers.");
        }

        // Beware that assignment is actually an expression.
        // An assignment has the value of the assignment.
        // This is why chained assignments work.
        System.out.println("\n************* CAUTION! *************");
        if (numIsEven = true) {
            System.out.println("This statement will always execute.");
        } else {
            System.out.println("This statement will never execute.");
        }

        System.out.println();

        if (3 == 4)
            System.out.println("woohoo");
            System.out.println("I love 3s"); // always happens

        System.out.println(favorites);
    }
}
