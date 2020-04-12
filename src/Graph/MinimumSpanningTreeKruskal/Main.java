package Graph.MinimumSpanningTreeKruskal;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        minimumSpanningTree(new int[][]{{0, 1, 1}, {1, 3, 5}, {0, 3, 6}, {0, 2, 9}, {2, 3, 8}});
        minimumSpanningTree(new int[][]{{0, 1, 6}, {0, 2, 3}, {0, 4, 7}, {1, 3, 9}, {1, 4, 5}, {1, 2, 4},
                {2, 4, 2}, {3, 4, 8}, {3, 5, 8}, {4, 5, 1}});

        minimumSpanningTree(new int[][]{{0, 1, 1}, {1, 3, 5}, {2, 3, 1}, {0, 2, 1}, {2, 1, 1}});

    }

    public static void minimumSpanningTree(int[][] graph) {

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

        Set<Integer> unionFind = new HashSet<>();

        int minimumDistance = 0;

        for (int i = 0; i < graph.length; i++)
            priorityQueue.add(new Edge(graph[i][0], graph[i][1], graph[i][2]));

        while (!priorityQueue.isEmpty()) {

            Edge edge = priorityQueue.poll();

            if (unionFind.contains(edge.src) && unionFind.contains(edge.dst)) {
                continue;
            } else {
                minimumDistance += edge.cost;
                unionFind.add(edge.src);
                unionFind.add(edge.dst);
                System.out.println(edge);
            }

        }

        System.out.println(minimumDistance);

    }


    public static class Edge implements Comparable<Edge> {
        int src;
        int dst;
        int cost;

        public Edge(int src, int dst, int cost) {
            this.src = src;
            this.dst = dst;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "src=" + src +
                    ", dst=" + dst +
                    ", cost=" + cost +
                    '}';
        }
    }

}
