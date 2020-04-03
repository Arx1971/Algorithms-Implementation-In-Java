package Graph.DepthFirstSearch;

import java.util.*;

public class Main {

    public static void main(String args[]) {

        GraphTraversal(new int[][]{{0, 2}, {2, 3}, {1, 2}, {3, 4}}, 5);

    }

    public static void GraphTraversal(int edges[][], int node) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < node; i++)
            graph.put(i, new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        boolean visited[] = new boolean[node];

        depthFirstSearch(graph, 0, visited);
    }

    public static void depthFirstSearch(Map<Integer, List<Integer>> graph, int node, boolean[] visited) {

        visited[node] = true;

        System.out.print(node + " ");

        List<Integer> nodes = graph.get(node);

        for (int i = 0; i < nodes.size(); i++) {
            if (!visited[nodes.get(i)]) {
                visited[nodes.get(i)] = true;
                depthFirstSearch(graph, nodes.get(i), visited);
            }
        }

    }

}
