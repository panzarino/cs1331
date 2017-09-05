public class Recitation2Loops {
    public static void main(String[] args) {
        String color = "red";
        switch (color) {
        case "red":
            System.out.println("It's red!");
            break;
        case "blue":
            System.out.println("It's blue!");
            break;
        default:
            System.out.println("Not red or blue!");
        }
        System.out.println("All done!");

        int counter = 0;
        while (counter < 5) {
            System.out.println("While loop running!");
            counter++;
        }

        int doCounter = 1;
        do {
            System.out.println("Running do while");
        } while (doCounter < 1);

        for (int i = 0; i < 10; i++) {
            System.out.println("Loop running! Iteration #: " + i);
        }
    }
}
