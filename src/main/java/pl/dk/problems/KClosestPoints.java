package pl.dk.problems;

import java.util.Arrays;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.util.Comparator.comparing;

/**
 * How would you find k closest points to the origin
 */
public class KClosestPoints {

    private final Point[] points = new Point[]{new Point(-2, -4), new Point(0, -2), new Point(-1, 0), new Point(3, -5),
            new Point(-2, -3), new Point(3, 2)};

    private final Point target = new Point(0, 0);

    private void closestSorting(int k) { // O(n log(n))
        for (Point point: points) {
            point.setDistance(target);
        } // O(n)
        // now problem rewritten to find k smallest items
        Arrays.sort(points, comparing(it -> it.distance)); // al-Pivot Quicksort O(n log(n))
        // take 3 first
        for (Point point: points) { // but lest print all
            System.out.println("-- " + point);
        }
    }

    private void closestInsertionSort(int k) { //  O(nk)
        Point[] closest = new Point[k];
        for (Point point1 : points) {
           point1.setDistance(target);
           for (int j = k - 1; j >= 0; j--) {
               if (closest[j] == null || closest[j].distance > point1.distance) {
                   if (j != k - 1) { // if last - simply remove
                       closest[j + 1] = closest[j];
                   }
                   closest[j] = point1;
               } else {
                   break;
               }
           }
        }
        for (Point point: closest) {
           System.out.println("-- " + point);
        }
    }

    public static void main(String[] args) {
        new KClosestPoints().closestSorting(3);
        System.out.println("----------------------------");
        new KClosestPoints().closestInsertionSort(4);
    }
}

class Point {
    final int x;
    final int y;
    double distance;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void setDistance(Point target) {
        distance = sqrt(pow(x - target.x, 2) + pow(y - target.y, 2));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")[" + distance + "]";
    }
}