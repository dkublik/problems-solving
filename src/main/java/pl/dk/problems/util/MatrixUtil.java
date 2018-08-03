package pl.dk.problems.util;

public class MatrixUtil {

    public static int[][] from(String... rows) {
        int[][] matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String row = rows[i];
            row = row.replaceAll("\\s+", ";");
            String[] numbers = row.split(";");
            matrix[i] = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                matrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        return matrix;
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.format("    %d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
