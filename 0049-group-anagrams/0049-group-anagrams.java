
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Convert string into character array
            char[] arr = str.toCharArray();

            // Sort the characters
            Arrays.sort(arr);

            // Create a sorted string as the key
            String key = new String(arr);

            // If key doesn't exist, create a new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add original string to its group
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
