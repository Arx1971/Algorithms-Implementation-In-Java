package StringManipulation.FindAllUniqueSubstringOfString;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String args[]) {

        System.out.println(findAllSubstring("abc"));

    }

    static Set<String> allSubstring;

    public static Set<String> findAllSubstring(String str) {
        allSubstring = new HashSet<>();

        backTrack(str, "", 0);

        return allSubstring;
    }

    public static void backTrack(String str, String currentString, int start) {

        for (int i = start; i < str.length(); i++) {
            currentString += str.charAt(i);
            allSubstring.add(currentString);
            backTrack(str, currentString, i + 1);
            currentString = currentString.substring(1);
        }

    }

}
