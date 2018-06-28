package pl.dk.problems.sort;

import java.util.Arrays;

import static pl.dk.problems.util.ArrayUtil.randomIntArray;

/**
 * 1. Array divided into sorted and unsorted
 * 2. Start with first (current) - find the smallest in unsorted array (subarray starting with current)
 * 3. Replace smallest with current
 * 4. Current is next
 *
 * O(n2)
 */
public class SelectionSort {

    private void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = i; j < array.length; j++) { // find min in unsorted array
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }
            // swap current with min
            int current = array[i];
            array[i] = min;
            array[minIndex] = current;
        }
    }

    public static void main(String[] args) {
        int[] array = randomIntArray();
        System.out.println("before: " + Arrays.toString(array));
        new SelectionSort().sort(array);
        System.out.println("after: " + Arrays.toString(array));
    }
}
