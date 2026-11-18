import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();

        if (sLen < pLen) {
            return result;
        }

        int[] pCount = new int[26];
        int[] windowCount = new int[26];

        // Populate frequency counts for p and the initial window in s
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            windowCount[s.charAt(i) - 'a']++;
        }

        // Check if the first window is an anagram
        if (Arrays.equals(pCount, windowCount)) {
            result.add(0);
        }

        // Slide the window across the rest of s
        for (int i = pLen; i < sLen; i++) {
            // Add the new character entering from the right
            windowCount[s.charAt(i) - 'a']++;
            // Remove the character leaving from the left
            windowCount[s.charAt(i - pLen) - 'a']--;

            // If frequency arrays match, record the start index of the current window
            if (Arrays.equals(pCount, windowCount)) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }
}