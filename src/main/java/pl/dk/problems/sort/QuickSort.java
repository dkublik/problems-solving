package pl.dk.problems.sort;

import java.util.Arrays;

import static pl.dk.problems.util.ArrayUtil.randomIntArray;

/**
 * 1. choose random pivot (this case value of middle index)
 * 2. partition table so that all values < pivot are on one (left) side and all > pivot on right side of table
 * 3. repeat for left side, repeat for left side
 *
 * O(n2)
 * but on average a(nlogn)
 */
public class QuickSort {

    private int[] sort(int[] array) {
        return sort(array, 0, array.length - 1);
    }

    private int[] sort(int[] array, int left, int right) {
        if (left >= right) {
            return array;
        }
        int oldLeft = left;
        int oldRight = right;
        int pivotIndex = (right + left) / 2;
        int pivot = array[pivotIndex];
        while (left < right) {
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        sort(array, oldLeft, left - 1);
        sort(array, left, oldRight);
        return array;
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        int[] array = randomIntArray();
        System.out.println("before: " + Arrays.toString(array));
        System.out.println("after: " + Arrays.toString(new QuickSort().sort(array)));
    }
}
