package Graph.FindingCycleInDirectedGraph;

import java.util.*;

public class Main {

    public static void main(String args[]) {

        System.out.println(CycleInDirectedGraph(new int[][]{{0, 1}, {1, 4}, {2, 3}, {3, 4}}, 5));
        System.out.println(CycleInDirectedGraph(new int[][]{{0, 1}, {1, 4}, {4, 3}, {3, 1}}, 5));
        System.out.println(CycleInDirectedGraph(new int[][]{{0, 1}, {1, 2}, {2, 0}}, 3));
    }

    public static boolean CycleInDirectedGraph(int edges[][], int nodes) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < nodes; i++)
            graph.put(i, new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
        }

        boolean visited[] = new boolean[nodes];

        return isCycleExistInGraph(0, graph, visited, new HashSet<>());
    }

    public static boolean isCycleExistInGraph(int src, Map<Integer, List<Integer>> graph, boolean[] visited, Set<Integer> set) {

        visited[src] = true;
        set.add(src);

        List<Integer> edges = graph.get(src);

        for (int i = 0; i < edges.size(); i++) {
            if (!visited[edges.get(i)])
                if (isCycleExistInGraph(edges.get(i), graph, visited, set))
                    return true;
                else if (set.contains(edges.get(i)))
                    return true;
        }
        set.remove(src);

        return false;
    }

}
