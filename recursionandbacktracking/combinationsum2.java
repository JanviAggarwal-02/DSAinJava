class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> current,
                           List<List<Integer>> ans) {

        // Target reached
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicates at the same level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Since array is sorted
            if (candidates[i] > target) {
                break;
            }

            // Choose
            current.add(candidates[i]);

            // i + 1 because each element can be used only once
            backtrack(candidates, target - candidates[i],
                      i + 1, current, ans);

            // Undo choice
            current.remove(current.size() - 1);
        }
    }
}