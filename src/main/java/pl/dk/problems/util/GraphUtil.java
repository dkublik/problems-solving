package pl.dk.problems.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GraphUtil {

   public static void printGraph(Map<String, List<String>> graph) {
       for (String node: graph.keySet()) {
           System.out.println(node + ": " + Arrays.toString(graph.get(node).toArray()));
       }
   }
}
