class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combin = new ArrayList<>();
        getAllCombinations(candidates, 0, target, ans, combin);
        return ans;
    }
public void getAllCombinations(int[] arr,int idx,int target,List<List<Integer>> ans,
                                    List<Integer> combin) {

        // Base cases
        if (target == 0) {
            ans.add(new ArrayList<>(combin));
            return;
        }
        if (idx == arr.length || target < 0) {
            return;
        }
        // TAKE
        combin.add(arr[idx]);
        getAllCombinations(arr,idx , target-arr[idx],ans,combin );
        combin.remove(combin.size() - 1);
        getAllCombinations(arr,idx + 1, target,ans,combin );
    }
}