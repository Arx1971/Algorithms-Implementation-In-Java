package Graph.BipartiteChecking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String args[]) {
        BipartiteGraph(new int[][]{{1, 0}, {3, 0}, {0, 2}, {3, 2}, {1, 2}}, 4);
        BipartiteGraph(new int[][]{{1, 0}, {3, 0}, {3, 2}, {1, 2}}, 4);
    }

    public static void BipartiteGraph(int edges[][], int nodes) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < nodes; i++)
            graph.put(i, new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[nodes];
        boolean[] color = new boolean[nodes];

        visited[0] = true;
        color[0] = false;

        if (isBipartite(0, graph, visited, color)) {
            System.out.println("Graph Is Bipartite");
        } else {
            System.out.println("Graph Is Not Bipartite");
        }
    }

    public static boolean isBipartite(int src, Map<Integer, List<Integer>> graph, boolean[] visited, boolean[] color) {

        visited[src] = true;

        List<Integer> edges = graph.get(src);

        for (int i = 0; i < edges.size(); i++) {
            if (!visited[edges.get(i)]) {
                color[edges.get(i)] = !color[src];
                if (!isBipartite(edges.get(i), graph, visited, color)) return false;
            } else if (color[src] == color[edges.get(i)]) return false;
        }

        return true;
    }

}
