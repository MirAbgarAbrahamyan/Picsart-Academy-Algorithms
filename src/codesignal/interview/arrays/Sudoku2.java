package codesignal.interview.arrays;

public class Sudoku2 {
    static boolean sudoku2(char[][] grid) {
        for (int i = 0; i < 9; i++) {
            int[] c1 = new int[9];
            int[] c2 = new int[9];
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] != '.') {
                    c1[grid[i][j] - '1']++;
                }
                if (grid[j][i] != '.') {
                    c2[grid[j][i] - '1']++;
                }
            }
            for (int j = 0; j < 9; j++) {
                if (c1[j] > 1 || c2[j] > 1) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 7; i += 3) {
            for (int j = 0; j < 7; j += 3) {
                int[] c = new int[9];
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (grid[k][l] != '.') {
                            c[grid[k][l] - '1']++;
                        }
                    }
                }
                for (int k = 0; k < 9; k++) {
                    if (c[k] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
