class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        getPerms(nums, 0, ans);
        return ans;
    }
    public void getPerms(int[] nums, int idx, List<List<Integer>> ans) {
    if (idx == nums.length) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
                list.add(num);
            }
        ans.add(list);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            getPerms(nums, idx + 1, ans);
            swap(nums, idx, i);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
}}