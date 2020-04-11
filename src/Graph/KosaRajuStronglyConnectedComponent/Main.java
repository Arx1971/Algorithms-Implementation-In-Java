package Graph.KosaRajuStronglyConnectedComponent;

import java.util.*;

public class Main {


    public static void main(String args[]) {

        Graph(new int[][]{{0, 1}, {0, 2}, {3, 2}, {3, 4}}, 5);

    }

    public static void Graph(int[][] edges, int nodes) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < nodes; i++)
            graph.put(i, new ArrayList<>());


        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[nodes];

        for (int i = 0; i < nodes; i++) {
            if (!visited[i])
                depthFirstSearch(graph, visited, i, stack);
        }

        Map<Integer, List<Integer>> reverseGraph = reverseGraph(edges, nodes);

        List<Stack<Integer>> stronglyConnectedComponent = new ArrayList<>();

        System.out.println(stack);

        Arrays.fill(visited, false);

        while (!stack.isEmpty()) {

            int src = stack.pop();
            if (!visited[src]) {
                Stack<Integer> dfs = new Stack<>();
                depthFirstSearch(reverseGraph, visited, src, dfs);
                stronglyConnectedComponent.add(dfs);
            }
        }

        System.out.println(stronglyConnectedComponent);

    }

    public static Map<Integer, List<Integer>> reverseGraph(int[][] edges, int nodes) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < nodes; i++)
            graph.put(i, new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        return graph;
    }


    public static void depthFirstSearch(Map<Integer, List<Integer>> graph, boolean[] visited, int src, Stack<Integer> stack) {

        visited[src] = true;

        List<Integer> connectedNodes = graph.get(src);

        for (int i = 0; i < connectedNodes.size(); i++) {
            if (!visited[connectedNodes.get(i)]) {
                depthFirstSearch(graph, visited, connectedNodes.get(i), stack);
            }
        }
        stack.push(src);

    }

}
