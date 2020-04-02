package SlidingWindow.minimumWindowSubstring;

import java.util.Arrays;

public class Main {

    public static void main(String args[]) {

        System.out.println(minWindow("ABBBBCBCA", "ABC"));

    }

    public static String minWindow(String s, String t) {

        int freq[] = new int[128];

        for (int i = 0; i < t.length(); i++)
            freq[t.charAt(i) - 'A']++;

        int right = 0, left = 0, count = t.length(), size = Integer.MAX_VALUE, ptr = 0;

        while (right < s.length()) {

            System.out.println(Arrays.toString(Arrays.copyOfRange(freq, 0, 3)));

            if (freq[s.charAt(right++) - 'A']-- > 0) count--;

            System.out.println(right);

            while (count == 0) {
                if (right - left < size) {
                    size = right - left;
                    ptr = left;
                }
                if (freq[s.charAt(left++) - 'A']++ == 0) count++;
            }
        }

        return size == Integer.MAX_VALUE ? "" : s.substring(ptr, ptr + size);

    }

}
