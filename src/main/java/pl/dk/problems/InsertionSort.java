package pl.dk.problems;

import java.util.Arrays;

import static pl.dk.problems.util.ArrayUtil.randomIntArray;

/**
 * 1. Array divided into sorted and unsorted
 * 2. First element in only element of sorted array
 * 2. Start with second (current) - start comparing with sorted from right
 * 3. Until bigger in sorted move to right and put current on its place
 *
 * O(n2)
 */
public class InsertionSort {

    private void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > current) {
                    array[j + 1] = array[j];
                    array[j] = current;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = randomIntArray();
        System.out.println("before: " + Arrays.toString(array));
        new InsertionSort().sort(array);
        System.out.println("after: " + Arrays.toString(array));
    }
}
