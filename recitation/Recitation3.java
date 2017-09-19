public class Recitation3 {
    public static void main(String[] args) {
        for (String argument : args) {
            System.out.println(argument);
        }
        System.out.println(addNumbers(3, 4));
        System.out.println(addNumbersUnknown(1, 2, 3, 4, 5));
    }
    public static int addNumbers(int aNum, int bNum) {
        return aNum + bNum;
    }
    public static int addNumbersUnknown(int ... nums) {
        int answer = 0;
        for (int i : nums) {
            answer += i;
        }
        return answer;
    }
}
