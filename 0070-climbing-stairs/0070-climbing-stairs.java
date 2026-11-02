class Solution {
    int dp[];
    public int climbStairs(int n) {
        dp = new int[n + 1];
        return solve(n);
    }

    private int solve(int n){
        if(n <= 2){
            return n;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        dp[n] = solve(n - 2) + solve(n - 1);
        return dp[n];
    }
}