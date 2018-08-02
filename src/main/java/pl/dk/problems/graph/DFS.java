package pl.dk.problems.graph;

import pl.dk.problems.util.GraphUtil;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * Depth first Search
 */
public class DFS {

    void visit(String node, Map<String, List<String>> graph, Set<String> visited) {
        System.out.println("---- visited: " + node);
        visited.add(node);
        for (String neighbour: graph.get(node)) {
           if (!visited.contains(neighbour)) {
               visit(neighbour, graph, visited);
           }
       }
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", asList("B", "C", "D"));
        graph.put("B", asList("C", "E"));
        graph.put("C", asList("E"));
        graph.put("D", asList("C", "F"));
        graph.put("E", asList("A"));
        graph.put("F", asList("C"));
        graph.put("G", asList("D","H"));
        graph.put("H", asList("C"));
        GraphUtil.printGraph(graph);
        System.out.println("------------");
        new DFS().visit("A", graph, new HashSet<>());
    }

}
