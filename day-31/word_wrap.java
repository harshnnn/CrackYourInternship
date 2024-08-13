class Solution {
    public int solveWordWrap(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cost = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);

        // Calculate cost for each possible end word
        for (int i = n - 1; i >= 0; i--) {
            int currentLength = -1;
            for (int j = i; j < n; j++) {
                currentLength += (nums[j] + 1);

                if (currentLength > k) {
                    break;
                }

                // Calculate cost if the line ends at word j
                int currentCost = (j == n - 1) ? 0 : (k - currentLength) * (k - currentLength);

                // Update dp[i] to be the minimum cost possible for words from i to n
                if (j < n - 1) {
                    dp[i] = Math.min(dp[i], currentCost + dp[j + 1]);
                } else {
                    dp[i] = currentCost;
                }
            }
        }

        return dp[0];
    }
}