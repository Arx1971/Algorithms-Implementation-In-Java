package Graph.DijkstraSingleSourceShortestPath;

import java.util.*;

public class Main {

    public static void main(String args[]) {

        DijkstraShortestPath(new int[][]{{0, 1, 4}, {0, 2, 2}, {2, 4, 10},
                {1, 3, 5}, {1, 2, 1}, {2, 3, 8}, {3, 4, 2}, {4, 5, 3}, {3, 5, 6}}, 6, 0, 5);

    }

    public static void DijkstraShortestPath(int[][] edges, int nodes, int src, int dst) {

        int[] distance = new int[nodes];
        boolean[] visited = new boolean[nodes];

        Arrays.fill(distance, Integer.MAX_VALUE);

        Map<Integer, List<Node>> graph = new HashMap<>();

        for (int i = 0; i < nodes; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new Node(edges[i][1], edges[i][2]));
            graph.get(edges[i][1]).add(new Node(edges[i][0], edges[i][2]));
        }

        dijkstra(graph, visited, distance, src);

        System.out.println(Arrays.toString(distance));

    }

    public static void dijkstra(Map<Integer, List<Node>> graph, boolean[] visited, int[] distance, int src) {

        distance[src] = 0;
        visited[src] = true;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {

            Node parent = pq.poll();
            visited[parent.v] = true;

            List<Node> nodes = graph.get(parent.v);

            for (int i = 0; i < nodes.size(); i++) {
                Node n = nodes.get(i);
                int child = n.v;
                int w = n.cost;
                if (distance[child] > distance[parent.v] + w) {
                    distance[child] = distance[parent.v] + w;
                    pq.add(new Node(child, distance[child]));
                }
            }

        }

    }

}

class Node implements Comparable<Node> {

    int v;
    int cost;

    Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node node) {

        if (this.cost > node.cost)
            return 1;
        if (this.cost < node.cost)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                ", cost=" + cost +
                '}';
    }
}