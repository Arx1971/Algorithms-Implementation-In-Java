package Graph.BipartiteCheckingNonRecursive;

import java.util.Stack;


public class Main {

    public static void main(String[] args) {

        int[][] graph = {{1}, {0, 3}, {3}, {2}};

        System.out.println(isBipartite(graph));

    }

    public static boolean isBipartite(int[][] graph) {

        boolean[] color = new boolean[graph.length];
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (!bipartiteCheck(graph, i, color, visited)) return false;
            }
        }
        return true;
    }

    public static boolean bipartiteCheck(int[][] graph, int src, boolean[] color, boolean[] visited) {

        visited[src] = true;
        color[src] = true;

        Stack<Integer> stack = new Stack<>();
        stack.push(src);

        while (!stack.isEmpty()) {
            int parent = stack.pop();
            int[] children = graph[parent];
            for (int child : children) {
                if (!visited[child]) {
                    visited[child] = true;
                    stack.push(child);
                    color[child] = !color[parent];
                } else if (color[child] == color[parent]) {
                    return false;
                }
            }
        }
        return true;
    }
}
