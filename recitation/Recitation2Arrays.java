public class Recitation2Arrays {
    public static void main(String[] args) {
        int[] array = new int[10];
        array[8] = 12;
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] + 3;
            System.out.println(array[i]);
        }

        System.out.println();

        for (int i : array) {
            System.out.println(i);
        }

        System.out.println();

        int[][] grid = new int[10][10];
        System.out.println(grid[2][3]);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j]++;
            }
        }
        System.out.println(grid[2][3]);
    }
}
