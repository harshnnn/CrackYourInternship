class Solution {
    public String longestCommonPrefix(String[] strs) {
       if (strs == null || strs.length == 0) {
            return "";
        }
      
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char key = strs[0].charAt(i); 
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || key != strs[j].charAt(i)) {
                    return strs[0].substring(0, count);
                }
            }
            count++;
        }

        return strs[0].substring(0, count);
    }
}