class Solution {
    static String maxNum;
    
    // Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k) {
        maxNum = str;
        findMaximumNumHelper(str.toCharArray(), k, 0);
        return maxNum;
    }
    
    private static void findMaximumNumHelper(char[] str, int k, int idx) {
        if (k == 0) {
            return;
        }
        
        int n = str.length;
        char maxChar = str[idx];
        
        // Find the maximum character to be swapped with str[idx]
        for (int i = idx + 1; i < n; i++) {
            if (str[i] > maxChar) {
                maxChar = str[i];
            }
        }
        
        // If maxChar is the same as str[idx], no need to swap, skip to the next digit
        if (maxChar != str[idx]) {
            k--;
        }
        
        // Swap str[idx] with every occurrence of maxChar after idx
        for (int i = idx; i < n; i++) {
            if (str[i] == maxChar) {
                swap(str, idx, i);
                
                String newStr = new String(str);
                if (newStr.compareTo(maxNum) > 0) {
                    maxNum = newStr;
                }
                
                findMaximumNumHelper(str, k, idx + 1);
                
                // Backtrack
                swap(str, idx, i);
            }
        }
    }
    
    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
