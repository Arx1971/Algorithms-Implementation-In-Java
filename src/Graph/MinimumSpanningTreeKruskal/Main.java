package Graph.MinimumSpanningTreeKruskal;


import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        minimumSpanningTree(new int[][]{{0, 1, 1}, {1, 3, 5}, {0, 3, 6}, {0, 2, 9}, {2, 3, 8}}, 4);
        minimumSpanningTree(new int[][]{{0, 1, 6}, {0, 2, 3}, {0, 4, 7}, {1, 3, 9}, {1, 4, 5}, {1, 2, 4},
                {2, 4, 2}, {3, 4, 8}, {3, 5, 8}, {4, 5, 1}}, 6);
        minimumSpanningTree(new int[][]{{0, 1, 1}, {1, 3, 5}, {2, 3, 1}, {0, 2, 1}, {2, 1, 1}}, 4);

        minimumSpanningTree(new int[][]{{0, 1, 4}, {0, 7, 8}, {1, 2, 8}, {1, 7, 11}, {2, 3, 7}, {2, 8, 2},
                {2, 5, 4}, {3, 4, 9}, {3, 5, 14}, {4, 5, 10}, {5, 6, 2}, {6, 7, 1}, {6, 8, 6}, {7, 8, 7}}, 9);

    }

    public static void minimumSpanningTree(int[][] graph, int nodes) {

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

        int minimumDistance = 0;

        for (int i = 0; i < graph.length; i++)
            priorityQueue.add(new Edge(graph[i][0], graph[i][1], graph[i][2]));

        int[] parent = new int[nodes];

        /** make set **/

        for (int i = 0; i < nodes; i++)
            parent[i] = i;


        while (!priorityQueue.isEmpty()) {

            Edge edge = priorityQueue.poll();

            int x = find(parent, edge.src);     /** find the parent of source **/
            int y = find(parent, edge.dst);     /** find the parent of destination **/

            if (x != y) {                       /** if x==y source and destination are in same set, means there is a cycle exist **/
                minimumDistance += edge.cost;
                union(parent, x, y);
                System.out.println(edge);
            }

        }

        System.out.println(minimumDistance);

    }

    /**
     * path compression
     **/

    public static int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex)
            return find(parent, parent[vertex]);
        return vertex;
    }

    public static void union(int[] parent, int x, int y) {
        int x_set_parent = find(parent, x);
        int y_set_parent = find(parent, y);
        parent[y_set_parent] = x_set_parent;
    }

    /**
     * initial set ->  {a}     {b}     {c}     {d}       {e}
     * path {a ,b}     {a,b}           {c}     {d}       {e}
     * path {c, e}     {a,b}           {c, e}  {d}
     * path {a, c}     {a,b,c,e}               {d}
     * path {c,d}      {a,b,c,e,d}
     **/

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
