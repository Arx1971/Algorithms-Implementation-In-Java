package DataStructure.DisjointSetUnion;

import java.util.Arrays;

public class Main {

    public static void main(String args[]) {

        int[] parent = make_set(7);

        union(2, 3, parent);
        union(7, 3, parent);
        System.out.println(Arrays.toString(parent));

    }

    public static int[] make_set(int v) {
        int[] parent = new int[v + 1];
        for (int i = 0; i <= v; i++)
            parent[i] = i;
        return parent;
    }

    public static int find(int a, int[] parent) {
        if (a == parent[a]) return a;
        return find(parent[a], parent);
    }

    public static void union(int a, int b, int[] parent) {
        a = find(a, parent);
        b = find(b, parent);
        if (a != b)
            parent[b] = a;
    }

}
