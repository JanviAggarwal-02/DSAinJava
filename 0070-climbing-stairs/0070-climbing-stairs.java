class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int twoStepsBefore = 1;
        int oneStepBefore = 2;

        for (int i = 3; i <= n; i++) {
            int current = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = current;
        }

        return oneStepBefore;
    }
}