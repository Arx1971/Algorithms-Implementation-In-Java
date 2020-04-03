package Graph.TopologicalSorting;

import java.util.*;

public class Main {

    public static void main(String args[]) {
        TopologicalSorting(new int[][]{{5, 0}, {5, 2}, {2, 3}, {4, 0}, {1, 3}}, 6);
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

        Arrays.fill(visited, false);
        Stack<Integer> sortedList = new Stack<>();
        for (int i = 0; i < nodes; i++)
            if (!visited[i])
                topologicalSort(graph, i, visited, sortedList);

        System.out.println(sortedList);

    }

    public static void topologicalSort(Map<Integer, List<Integer>> graph, int src, boolean[] visited, Stack<Integer> stack) {

        visited[src] = true;

        List<Integer> edges = graph.get(src);

        for (int i = 0; i < edges.size(); i++) {
            if (!visited[edges.get(i)]) {
                topologicalSort(graph, edges.get(i), visited, stack);
            }
        }
        stack.add(src);
    }

    public static boolean GraphHasCycle(Map<Integer, List<Integer>> graph, int src, Set<Integer> set, boolean[] visited) {

        visited[src] = true;

        set.add(src);

        List<Integer> edges = graph.get(src);

        for (int i = 0; i < edges.size(); i++) {
            if (!visited[edges.get(i)]) {
                if (GraphHasCycle(graph, edges.get(i), set, visited)) return true;
            } else if (set.contains(edges.get(i))) return true;
        }
        set.remove(src);
        return false;
    }


}
