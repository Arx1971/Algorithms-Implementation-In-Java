package Graph.BridgesInGraph;

import java.util.*;

public class Main {

    public static void main(String args[]) {

        Graph(new int[][]{{0, 1}, {1, 2}, {2, 0}, {1, 3}}, 4);

    }

    static int time;
    static List<List<Integer>> solution;

    public static void Graph(int edges[][], int nodes) {

        time = 0;

        solution = new ArrayList<>();

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < nodes; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[nodes];
        int[] low = new int[nodes];
        int[] parent = new int[nodes];
        int[] discover = new int[nodes];

        Arrays.fill(parent, -1);

        for (int i = 0; i < nodes; i++)
            if (!visited[i])
                depthFirstSearch(graph, i, visited, low, parent, discover);


        System.out.println(solution);
    }

    public static void depthFirstSearch(Map<Integer, List<Integer>> graph, int src, boolean[] visited, int[] low, int[] parent, int[] discover) {

        visited[src] = true;

        discover[src] = low[src] = time++;

        List<Integer> adjacent = graph.get(src);

        for (int i = 0; i < adjacent.size(); i++) {
            if (!visited[adjacent.get(i)]) {
                parent[adjacent.get(i)] = src;
                depthFirstSearch(graph, adjacent.get(i), visited, low, parent, discover);
                low[src] = Math.min(low[src], low[adjacent.get(i)]);
                if (discover[src] < low[adjacent.get(i)]) solution.add(Arrays.asList(src, adjacent.get(i)));
            } else if (adjacent.get(i) != parent[src])
                low[src] = Math.min(low[src], discover[adjacent.get(i)]);
        }

    }

}
