package pl.dk.problems.search;

import java.util.Arrays;

import static pl.dk.problems.util.ArrayUtil.randomIntArray;

public class BinarySearch { // O(log(n))

    private int searchWithWhile(int[] array, int toFind) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == toFind) {
                return mid;
            } else if (array[mid] > toFind) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private int searchRecursively(int[] array, int toFind, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == toFind) {
            return mid;
        } else if (array[mid] > toFind) {
            return searchRecursively(array, toFind, start, mid - 1);
        } else {
            return searchRecursively(array, toFind, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] array = randomIntArray();
        Arrays.sort(array);
        int toFind = array[7];
        System.out.println("array: " + Arrays.toString(array));
        System.out.println("index with while: " + new BinarySearch().searchWithWhile(array, toFind));
        System.out.println("index recursively: " + new BinarySearch().searchRecursively(array, toFind, 0, array.length - 1));
    }
}
