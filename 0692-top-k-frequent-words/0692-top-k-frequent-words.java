import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // 1. Count the frequency of each word
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // 2. Min-Heap to store the top k frequent words
        // Evict lower frequency first; if frequencies match, evict lexicographically larger word first
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            int freqCompare = freqMap.get(a).compareTo(freqMap.get(b));
            if (freqCompare == 0) {
                return b.compareTo(a); // Reverse alphabetical order for eviction
            }
            return freqCompare; // Ascending frequency order for eviction
        });

        // 3. Maintain heap size at most k
        for (String word : freqMap.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 4. Extract elements from the heap and reverse to get highest frequency first
        LinkedList<String> result = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            result.addFirst(minHeap.poll());
        }

        return result;
    }
}