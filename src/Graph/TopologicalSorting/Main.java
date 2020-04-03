package Graph.TopologicalSorting;

import java.util.*;

public class Main {

    public static void main(String args[]) {

        TopologicalSorting(new int[][]{{0, 1}, {1, 4}, {2, 3}, {3, 4}}, 5);
        TopologicalSorting(new int[][]{{0, 1}, {1, 4}, {4, 3}, {3, 1}}, 5);
        TopologicalSorting(new int[][]{{0, 1}, {1, 2}, {2, 0}}, 3);

    }


    public static void TopologicalSorting(int[][] edges, int nodes) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < nodes; i++)
            graph.put(i, new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
        }

        boolean[] visited = new boolean[nodes];

        if (GraphHasCycle(graph, 0, new HashSet<>(), visited)) {
            System.out.println("Graph Has Cycle in it");
            return;
        }

    }

    public static boolean GraphHasCycle(Map<Integer, List<Integer>> graph, int src, Set<Integer> set, boolean[] visited) {

        visited[src] = true;

        set.add(src);

        List<Integer> nodes = graph.get(src);

        for (int i = 0; i < nodes.size(); i++) {
            if (!visited[nodes.get(i)]) {
                if (GraphHasCycle(graph, nodes.get(i), set, visited)) return true;
            } else if (set.contains(nodes.get(i))) return true;
        }
        set.remove(src);
        return false;
    }


}
