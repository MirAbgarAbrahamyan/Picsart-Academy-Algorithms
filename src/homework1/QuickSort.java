package homework1;

import helper.Utility;

public class QuickSort {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[Utility.randExclusive(left, right)];
            int index = partition(arr, left, right, pivot);
            sort(arr, left, index - 1);
            sort(arr, index, right);
        }
    }

    private static int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                Utility.swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
}
