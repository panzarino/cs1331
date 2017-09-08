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
    public static void main(String[] args) {
        int[] nums = new int[25];
        double[] scores;
        int numstudents = 143;
        scores = new double[numstudents];
        char[] letters = {'A', 'B', 'C', 'D', 'F'};

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
    }
}
