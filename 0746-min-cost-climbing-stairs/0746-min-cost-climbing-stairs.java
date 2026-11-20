class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int twoStepsBefore = 0;
        int oneStepBefore = 0;

        for (int i = 2; i <= cost.length; i++) {
            int current = Math.min(oneStepBefore + cost[i - 1], twoStepsBefore + cost[i - 2]);
            twoStepsBefore = oneStepBefore;
            oneStepBefore = current;
        }

        return oneStepBefore;
    }
}