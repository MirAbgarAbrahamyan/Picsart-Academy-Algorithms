package codesignal.interview.arrays;

public class FirstNotRepeatingCharacter {
    char firstNotRepeatingCharacter(String s) {
        int[] c = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (c[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return '_';
    }
}
