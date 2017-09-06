public class Loopy {
    public static boolean method(int num, boolean outsideMode) {
        return (outsideMode) ? num <= 1 || num >= 10 : 1 <= num && num <= 10;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        boolean keepGoing = true;
        int num = 0;
        while (keepGoing) {
            System.out.println("Awesome");
            num++;
            keepGoing = num < 10;
        }

        String word = "RESPECT";
        for (int i = 0, j = word.length() - 1; i < word.length(); i++, j--) {
            System.out.println(word.charAt(i));
            System.out.println(word.charAt(j));
        }
    }
}
