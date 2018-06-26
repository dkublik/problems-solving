package pl.dk.problems.util;

public class ArrayUtil {

    public static int[] randomIntArray(int size, int min, int max) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int)(Math.random() * (max - min + 1)) + min;
        }
        return array;
    }

    public static int[] randomIntArray(int size) {
        return randomIntArray(size, 0, 100);
    }

    public static int[] randomIntArray() {
        return randomIntArray(15);
    }

}
