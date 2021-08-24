package helper;

import java.util.Random;

public class Utility {
    private static final Random random = new Random();

    public static int randExclusive(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
