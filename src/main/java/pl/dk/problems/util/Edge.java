package pl.dk.problems.util;

public class Edge {
    public int weight;
    public String target;
    
    public Edge(String target, int weight) {
        this.weight = weight;
        this.target = target;
    }

    @Override
    public String toString() {
        return "{" + target + ", " + weight + "}";
    }
}