package Graph.BellManFordSingleSourceShortestPath;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[][] graph = {{0, 1, -1}, {0, 2, 4},
                {1, 2, 3}, {1, 3, 2},
                {1, 4, 2}, {3, 2, 5},
                {3, 1, 1}, {4, 3, -3}};

        bellManFord(graph, 5, 0);

        bellManFord(new int[][]{{0, 1, 1}, {1, 0, 3}}, 2, 1);

    }

    public static void bellManFord(int[][] graph, int n, int src) {

        int[] distance = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[src] = 0;

        for (int i = 0; i < n - 1; i++) {

            for (int[] edge : graph) {
                int u = edge[0];
                int v = edge[1];
                int cost = edge[2];
                if (distance[u] != Integer.MAX_VALUE && distance[u] + cost < distance[v]) {
                    distance[v] = distance[u] + cost;
                }
            }
        }

        System.out.println(Arrays.toString(distance));

    }

}
