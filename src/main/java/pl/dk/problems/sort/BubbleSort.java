package pl.dk.problems.sort;

import java.util.Arrays;

import static pl.dk.problems.util.ArrayUtil.randomIntArray;

/**
 * 1. do until array is not sorted
 * 2. go from beginning till end
 * 3. if two neighbors are not sorted -> swap
 * 4. if at least one swap -> array was not sorted -> repeat
 * 5. optimization: after each iteration last index is in place and can be skipped in next iteration
 *
 * O(n2)
 */
public class BubbleSort {

    private int[] sort(int[] array) {
        boolean sorted = false;
        int lastIndex = array.length - 1;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < lastIndex; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    sorted = false;
                }
            }
            lastIndex--;
        }
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
        System.out.println("after: " + Arrays.toString(new BubbleSort().sort(array)));
    }
}
