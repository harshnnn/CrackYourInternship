import java.util.ArrayList;

class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), S, 0);
        return result;
    }

    static void backtrack(ArrayList<ArrayList<String>> result, ArrayList<String> tempList, String S, int start) {
        if (start == S.length()) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        for (int i = start; i < S.length(); i++) {
            if (isPalindrome(S, start, i)) {
                tempList.add(S.substring(start, i + 1));
                backtrack(result, tempList, S, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String S, int low, int high) {
        while (low < high) {
            if (S.charAt(low) != S.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
