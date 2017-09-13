public class ArrayPractice {
    public static void printMyArray(int[] nums) {
        for (int i:nums) {
            System.out.println(i);
        }
    }
    public static boolean more14(int[] nums) {
        int num1 = 0, num4 = 0;
        for (int num:nums) {
            if (num == 1) {
                num1++;
            } else if (num == 4) {
                num4++;
            }
        }
        return num1 > num4;
    }
    public static void printNumbers(double ... nums) {
        for (double n : nums) {
            System.out.println(n);
        }
    }
    public static void print2DArray(String[][] items) {
        for (String[] i : items) {
            for (String s : i) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[25];
        double[] scores;
        int numstudents = 143;
        scores = new double[numstudents];
        char[] letters = {'A', 'B', 'C', 'D', 'F'};
        String[][] seats = new String[5][6];

        for (int r = 0; r < seats.length; r++) {
            for (int c = 0; c < seats[r].length; c++) {
                seats[r][c] = "Spongebob";
            }
        }

        // System.out.println(nums);
        System.out.println(nums[0]);
        System.out.println(nums[24]);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = nums[i] + 25;
        }

        for (int number:nums) {
            System.out.println(number);
        }

        printMyArray(nums);

        int[] testnums = {4, 1, 2, 1};
        System.out.println(more14(testnums));

        printNumbers(3, 4);
        printNumbers(1, 2, 3, 7);
        printNumbers();

        print2DArray(seats);
    }
}
