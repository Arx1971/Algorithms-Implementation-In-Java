package DynamicProgramming.CountTheNumberOfWaysToTileTheFloor;

public class Main {

    public static void main(String[] args) {

        System.out.println(numberOfWaysTileNMFloor(5, 1));

    }

    public static long numberOfWaysTileNMFloor(int n, int m) {
        if (n < m) return 1;
        else if (n == m) return 2;

        double golderRatio = ((1 + Math.sqrt(5)) / 2);
        double phi = Math.pow(golderRatio, n);

        return Math.round(((phi) / Math.sqrt(5)));
    }

}
