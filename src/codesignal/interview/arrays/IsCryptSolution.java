package codesignal.interview.arrays;

public class IsCryptSolution {
    boolean isCryptSolution(String[] crypt, char[][] solution) {
        for (int i = 0; i < 3; i++) {
            for (char[] chars : solution) {
                crypt[i] = crypt[i].replace(chars[0], chars[1]);
            }
        }
        for (int i = 0; i < 3; i++) {
            if (!crypt[i].equals("0") && crypt[i].charAt(0) == '0') {
                return false;
            }
        }
        return Long.parseLong(crypt[0]) + Long.parseLong(crypt[1]) == Long.parseLong(crypt[2]);
    }
}
