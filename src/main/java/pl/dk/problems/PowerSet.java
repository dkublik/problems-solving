package pl.dk.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * set of all sets from integers from 1 to n
 */
public class PowerSet {

    List<List<Integer>> generatePowerSet(int size) {
        if (size == 0) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        List<List<Integer>> existingSubsets = generatePowerSet(size - 1);
        List<List<Integer>> newSubSets = new ArrayList<>();
        for (List<Integer> existingSubset: existingSubsets) {
           List<Integer> newSubSet = new ArrayList<>();
           newSubSet.addAll(existingSubset);
           newSubSet.add(size);
           newSubSets.add(newSubSet);
        }
        existingSubsets.addAll(newSubSets);
        return existingSubsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> powerSet = new PowerSet().generatePowerSet(4);
        System.out.println("powerSet: " + powerSet);
    }

}
