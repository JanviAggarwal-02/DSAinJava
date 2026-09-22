class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), ans);
        return ans;
    }


    private void backtrack(int index, int[] nums, List<Integer> curr,
                           List<List<Integer>> ans) {

        ans.add(new ArrayList<>(curr));

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);              // Choose
            backtrack(i + 1, nums, curr, ans); // Explore
            curr.remove(curr.size() - 1);  // Backtrack
        }
    }
}