package StringManipulation.MaximumOccurrenceOfPrefixInTheArray;

public class Main {

    public static void main(String args[]) {

        System.out.println(maximumOccurrencesOfPrefix("abccdad"));

    }

    public static int maximumOccurrencesOfPrefix(String str) {
        char c = str.charAt(0);
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c)
                count++;
        }

        return count;
    }

}
