package StringManipulation.AllTheSubstringOfAString;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {

        System.out.println(printAllSubstring("abcd"));

    }

    public static List<String> printAllSubstring(String str) {
        List<String> solution = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                solution.add(str.substring(i, j));
            }
        }

        return solution;
    }

}
