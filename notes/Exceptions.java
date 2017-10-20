import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Exceptions {

    public static void main(String[] args) throws FileNotFoundException{
        method2();
    }

    public static void method1() {
        try {
            Scanner scan = new Scanner(new File("p.txt"));
            System.out.println("method1");
        } catch (FileNotFoundException e) {
            System.out.println("caught exception" + e.getMessage());
        }
    }

    public static void method2() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("p.txt"));
        System.out.println("method2");
    }

    public static void method3() {

    }

}
