package pl.dk.problems.sort;

import java.util.*;

import static pl.dk.problems.util.ArrayUtil.randomIntArray;

/**
 * 1. for every number from range -> count occurrence
 * 2. by occurrence count smallest index
 * 3. shift indexes one to the right
 * 4. iterate through input - for every item put it to smallest Index and increase smallest
 * index for this number next occurrence
 *
 * O(n + k)
 * k is the range of sorted elements
 */
public class CountingSort {

    private int[] sort(int[] array) {
        Map<Integer, Integer> occurrences = new LinkedHashMap();
        for (int i = 0; i <= 100; i++) { // <0, 100> is range of array
            occurrences.put(i, 0);
        } // initialize every occurrence from range with 0
        for (int value: array) {
            occurrences.put(value, occurrences.get(value) + 1);
        } // count every occurrence
        for (int i = 1; i <= 100; i++) { // <0, 100> is range of array
            occurrences.put(i, occurrences.get(i - 1) + occurrences.get(i));
        } // count smallest index for every number
        for (int i = 100; i > 0; i--) { // <0, 100> is range of array
            occurrences.put(i, occurrences.get(i - 1));
        } // shift smallest indexes
        occurrences.put(0, 0);
        int[] sorted = new int[array.length];
        for (int value: array) {
            sorted[occurrences.get(value)] = value;
            occurrences.put(value, occurrences.get(value) + 1);
        }
        return sorted;
    }

    public static void main(String[] args) {
        int[] array = randomIntArray();
        System.out.println("before: " + Arrays.toString(array));
        System.out.println("after: " + Arrays.toString(new CountingSort().sort(array)));
    }
}
