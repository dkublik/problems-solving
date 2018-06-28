package pl.dk.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static pl.dk.problems.util.ArrayUtil.randomIntArray;

/**
 * Find two integers that multiply to 20
 * is array sorted
 * can number repeat?
 * any two? all two?
 * what should I return? Numbers? Indexes? Can I just print?
 */
public class TwoIntegersThatMultiplyTo20 {

    private void findNaively(int[] array) { // O(n2)
       for (int i = 0; i < array.length; i++) {
           for (int j = 0; j < array.length; j++) {
               if (i == j) {
                   continue;
               }
               if (array[j]*array[i] == 20) {
                   System.out.println("found: (" + array[i] + ", " + array[j] + ")");
               }
           }
       }
    }

    private void findWithSet(int[] array) { // O(n)
        Set<Integer> factors = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0 || 20 % array[i] != 0) {
                continue;
            }
            int missing = 20 / array[i];
            if (factors.contains(missing)) {
                System.out.println("found: (" + array[i] + ", " + missing + ")");
            } else {
                factors.add(array[i]);
            }
        }
    }

    private void findForSorted(int[] array) { // O(n)
        int start = 0;
        int end = array.length - 1;
        while (start != end) {
            int startValue = array[start];
            int endValue = array[end];
            if (startValue * endValue == 20) {
                System.out.println("found: (" + startValue + ", " + endValue + ")");
                start++;
            } else if (startValue * endValue < 20) {
                start++;
            } else {
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = randomIntArray(15, 0, 30);
        // int[] array = new int[]{21, 11, 25, 17, 23, 27, 11, 10, 6, 1, 5, 22, 12, 3, 2};
        System.out.println("array: " + Arrays.toString(array));
        System.out.println("------------ naively");
        new TwoIntegersThatMultiplyTo20().findNaively(array);
        System.out.println("------------ with Set");
        new TwoIntegersThatMultiplyTo20().findWithSet(array);
        System.out.println("------------ findForSorted");
        Arrays.sort(array);
        System.out.println("array: " + Arrays.toString(array));
        new TwoIntegersThatMultiplyTo20().findForSorted(array);
    }

}
