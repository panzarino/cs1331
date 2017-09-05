import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;

public class Recitation2IO {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your age: ");
        int myAge = scan.nextInt();
        System.out.println("My age is: " + myAge);
        scan.nextLine();
        System.out.print("Please enter your name: ");
        String myName = scan.nextLine();
        System.out.println("My name is: " + myName);

        Scanner textScanner = new Scanner(new File("input.txt"));
        System.out.println(textScanner.hasNextLine());
        while (textScanner.hasNextLine()) {
            System.out.println(textScanner.nextLine());
        }

        PrintStream myStream = new PrintStream(new File("output.txt"));
        myStream.println("Yay!");
        myStream.println("Something is here!");
    }
}
