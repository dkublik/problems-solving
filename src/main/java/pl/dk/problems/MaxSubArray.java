package pl.dk.problems;

import java.util.Arrays;

/**
 * find subArray with max sum
 * e.g for [1, -3, 2, 1, -1] = [2, 1]
 * as 2 + 1 = 3
 */
public class MaxSubArray {

    int[] maxSubArray(int[] array) {
        int maxSum = array[0];
        int maxStart = 0;
        int maxEnd = 1;
        int currentSum = array[0];
        int currentStart = 0;
        for (int i = 1; i < array.length; i++) {
            currentSum += array[i];
            if (array[i] > currentSum) {
                currentSum = array[i];
                currentStart = i;
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxStart = currentStart;
                maxEnd = i + 1;
            }
        }
        return Arrays.copyOfRange(array, maxStart, maxEnd);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, -3, 2, 1, -1, -10};
        int[] maxSubArray = new MaxSubArray().maxSubArray(array);
        System.out.println("max subarray: " + Arrays.toString(maxSubArray));
    }

}
