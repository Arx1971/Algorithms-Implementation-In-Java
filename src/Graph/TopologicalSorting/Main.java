package Graph.TopologicalSorting;

import java.util.*;

public class Main {

    public static void main(String args[]) {

        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++)
            graph.put(i, new ArrayList<>());

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        boolean visited[] = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i])
                if (hasCycle(graph, i, set, stack, visited)) return new int[]{};
        }


        int[] solution = new int[numCourses];

        for (int i = solution.length - 1; i >= 0; i--)
            solution[i] = stack.pop();

        return solution;
    }

    public static boolean hasCycle(Map<Integer, List<Integer>> graph, int src, Set<Integer> set, Stack<Integer> stack, boolean visited[]) {

        visited[src] = true;
        set.add(src);

        List<Integer> edges = graph.get(src);

        for (int i = 0; i < edges.size(); i++) {
            if (!visited[edges.get(i)]) {
                if (hasCycle(graph, edges.get(i), set, stack, visited)) return true;
            } else if (set.contains(edges.get(i))) {
                return true;
            }
        }
        stack.add(src);
        set.remove(src);

        return false;
    }

}
