class Solution
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        // Create a set for quick lookup of dictionary words
        Set<String> wordDict = new HashSet<>(B);

        // Create a DP array to store whether a substring can be segmented
        boolean[] dp = new boolean[A.length() + 1];

        // Base case: an empty string can always be segmented
        dp[0] = true;

        // Fill the DP array
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 0; j < i; j++) {
                // Check if the substring from j to i can be segmented
                if (dp[j] && wordDict.contains(A.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further once dp[i] is true
                }
            }
        }

        // The value at dp[A.length()] tells whether the entire string can be segmented
        return dp[A.length()] ? 1 : 0;
    }
}