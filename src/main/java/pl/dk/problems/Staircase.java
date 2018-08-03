package pl.dk.problems;

/**
 * we have stairway of 100 steps
 * each jump we can take 1, 2 or 3 steps
 * how many paths are possible?
 */
public class Staircase {

    int pathsRecursive(int steps) {
        if (steps < 0) {
            return 0;
        }
        if (steps == 0) {
            return 1;
        }
        return pathsRecursive(steps - 1) + pathsRecursive(steps - 2) + pathsRecursive(steps - 3);
    }

    int pathsMemoization(int steps, int[] memo) {
        if (steps < 0) {
            return 0;
        }
        if (steps == 0) {
            return 1;
        }
        if (memo[steps] != 0) {
            return memo[steps];
        }
        memo[steps] = pathsMemoization(steps - 1, memo) + pathsMemoization(steps - 2, memo)
                + pathsMemoization(steps - 3, memo);
        return memo[steps];
    }

    int pathsBottomUp(int steps) {
        int[] paths = new int[steps + 1];
        paths[0] = 1;
        paths[1] = 1;
        paths[2] = 2;
        for (int i = 3; i <= steps; i++) {
            paths[i] = paths[i - 3] + paths[i - 2] + paths[i -1];
        }
        return paths[steps];
    }

    // the only one tha can solve steps > 37, as number of possibilities > int.MAX,
    // and int is used ad array index
    long pathsBottomUpConstantSpaceComplexity(int steps) {
        long[] paths = new long[3];
        paths[0] = 1;
        paths[1] = 1;
        paths[2] = 2;
        for (int i = 3; i <= steps; i++) {
            long count = paths[0] + paths[1] + paths[2];
            paths[0] = paths[1];
            paths[1] = paths[2];
            paths[2] = count;
        }
        return paths[2];
    }

    public static void main(String[] args) {
        long paths = new Staircase().pathsBottomUpConstantSpaceComplexity(100);
        System.out.println("paths: " + paths);
    }

}
