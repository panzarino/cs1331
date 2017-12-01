public class RecursivePractice {

    public static void recCountDown(int n) {
        if (n == 0) {
            System.out.println(0);
        } else {
            System.out.println(n);
            recCountDown(n - 1);
        }
    }

    public static int sumUp(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumUp(n - 1);
    }

    public static void main(String[] args) {
        recCountDown(10);
        System.out.println(sumUp(100));
    }
}
