package ru.vsu.cs.program;


public class Task {
    public static void Process(int[][] arr2) {
        for (int r = 0; r < arr2.length; r++) {
            for (int c = 0; c < arr2[r].length; c++) {
                arr2[r][c]++;
            }
        }
    }

    public static int[][] Process2(int[][] arr2) {
        int[][] res = new int[2][2];
        for (int r = 0; r < Math.min(arr2.length, 2); r++) {
            for (int c = 0; c < Math.min(arr2[0].length, 2); c++) {
                res[r][c] = arr2[r][c];
            }
        }
        return res;
    }


    public static void reverseRows(int[][] arr2) {
        for (int r = 0; r < arr2.length / 2; r++) {
            int[] temp = arr2[r];
            arr2[r] = arr2[arr2.length - r - 1];
            arr2[arr2.length - r - 1] = temp;
        }
    }

    public static void reverseColumns(int[][] arr2) {
        int colsCount = arr2[0].length;
        for (int c = 0; c < colsCount / 2; c++) {
            swapColumns(arr2,  c, colsCount - c - 1);
        }
    }

    public static void swapColumns(int[][] arr2, int c1, int c2) {
        for (int[] row : arr2) {
            int temp = row[c1];
            row[c1] = row[c2];
            row[c2] = temp;
        }
    }
}
