package pl.dk.problems;

import pl.dk.problems.util.MatrixUtil;

/**
 * find largest square in matrix
 * we iterate from upper left assuming we are right bottom corner
 * so that if we are one the largest matrix that I'm bottom right of is min of largest matrix
 * for all may top / left neighbours + 1
 */
public class LargestSquareInMatrix {

    int[][] largestSquare(int[][] matrix) {
        int[][] largestSquare = new int[matrix.length][matrix[0].length];
        for (int column = 0; column < matrix.length; column++) {
            for (int row = 0; row < matrix[column].length; row++) {
                if (column == 0 || row == 0) {
                    largestSquare[column][row] = matrix[column][row];
                } else if (matrix[column][row] == 0) {
                    largestSquare[column][row] = 0;
                } else {
                    largestSquare[column][row] = 1 + Math.min(largestSquare[column][row - 1],
                            Math.min(largestSquare[column - 1][row], largestSquare[column - 1][row - 1]));
                }
            }
        }
        return largestSquare;
    }

    public static void main(String[] args) {
        int[][] matrix = MatrixUtil.from(
                "1    1    0    1    0",
                      "0    1    1    1    0",
                      "1    1    1    1    0",
                      "0    1    1    1    1"
        );
        System.out.println("----- matrix");
        MatrixUtil.print(matrix);
        int[][] largestSquare = new LargestSquareInMatrix().largestSquare(matrix);
        System.out.println("----- largest Square");
        MatrixUtil.print(largestSquare);
    }

}
