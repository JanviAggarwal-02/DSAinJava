class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;

        // Count frequencies and find max frequency
        for (char task : tasks) {
            freq[task - 'A']++;
            if (freq[task - 'A'] > maxFreq) {
                maxFreq = freq[task - 'A'];
            }
        }

        // Count how many tasks share the maximum frequency
        int maxCount = 0;
        for (int count : freq) {
            if (count == maxFreq) {
                maxCount++;
            }
        }

        // Apply formula
        int minIntervals = (maxFreq - 1) * (n + 1) + maxCount;

        return Math.max(tasks.length, minIntervals);
    }
}