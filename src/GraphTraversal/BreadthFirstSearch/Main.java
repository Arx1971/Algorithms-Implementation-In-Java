package GraphTraversal.BreadthFirstSearch;

import java.util.*;

public class Main {

    public static void main(String args[]) {
        GraphTraversal(new int[][]{{0, 2}, {2, 3}, {1, 2}, {3, 4}}, 5);
    }

    public static void GraphTraversal(int edges[][], int nodes) {

        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < nodes; i++)
            graph.put(i, new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[nodes];
        int[] distanceArray;

        distanceArray = BreadthFirstSearch(graph, 2, visited);

        System.out.println(Arrays.toString(distanceArray));

        System.out.println(distanceArray[1]);

    }

    public static int[] BreadthFirstSearch(Map<Integer, List<Integer>> graph, int src, boolean[] visited) {

        int[] distanceArray = new int[visited.length];

        distanceArray[src] = 0;
        visited[src] = true;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);

        while (!queue.isEmpty()) {

            int parent = queue.poll();

            List<Integer> nodes = graph.get(parent);

            for (int i = 0; i < nodes.size(); i++) {
                if (!visited[nodes.get(i)]) {
                    visited[nodes.get(i)] = true;
                    distanceArray[nodes.get(i)] = distanceArray[parent] + 1;
                    queue.add(nodes.get(i));
                }
            }
        }

        return distanceArray;
    }

}
