public class Recitation4 {
    public static final double CONSTANT_PI = 3.1415;

    public static boolean myMethod() {
        System.out.println("Method");
        return false;
    }

    public static void main(String[] args) {
        Month firstMonth = Month.January;
        Month secondMonth = Month.January;
        System.out.println(firstMonth);
        System.out.println(firstMonth == secondMonth);
        System.out.println(firstMonth.ordinal() < secondMonth.ordinal());
        if (0 < 42 || myMethod()) {
            System.out.println("Something");
        }

        int counter = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j = j + 2) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
