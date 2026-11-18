class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // Frequency array for ASCII characters (covers uppercase & lowercase English letters)
        int[] freq = new int[128];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int count = t.length(); // Total characters still needed to form a valid window

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            // If this character is still needed for t, decrement the needed count
            if (freq[rightChar] > 0) {
                count--;
            }
            // Decrement frequency (characters not in t become negative)
            freq[rightChar]--;

            // When all characters from t are included in the current window
            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                freq[leftChar]++;

                // If removing leftChar causes a deficit of a required character, window is no longer valid
                if (freq[leftChar] > 0) {
                    count++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}