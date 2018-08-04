package pl.dk.problems;

/**
 * input: array if size of tower on each position
 * from each position can make that many jumps as high my position is
 * on each jump there can my no higher obstacle than my current height
 * check if path is hoppable
 */
public class TowerHopper {

    boolean isHoppable(int start, int[] towers) {
        if (start >= towers.length) {
            return true;
        }
        int currentHeight = towers[start];
        for (int i = 1; i<= currentHeight; i++) {
            if (canJump(start, i, towers) && isHoppable(start + i, towers)) {
                return true;
            }
        }
        return false;
    }

    private boolean canJump(int position, int steps, int[] towers) {
        int currentHeight = towers[position];
        if (steps > currentHeight) {
            return false;
        }
        for (int i = 0; i <= steps; i++) {
            if (position + i >= towers.length) {
                return true;
            }
            if (towers[position + i] > currentHeight) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] towers = new int[]{4, 2, 0, 0, 2, 0};
        boolean isHoppable = new TowerHopper().isHoppable(0, towers);
        System.out.println("is hoppable: " + isHoppable);
    }

}
