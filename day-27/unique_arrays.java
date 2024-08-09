//User function Template for Java

class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(arr); // Sort the array to handle duplicates
        backtrack(result, arr, new ArrayList<>(), new boolean[n]);
        return result;
    }

    static void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> arr, ArrayList<Integer> tempList, boolean[] used) {
        if (tempList.size() == arr.size()) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < arr.size(); i++) {
                if (used[i] || (i > 0 && arr.get(i) == arr.get(i-1) && !used[i - 1])) continue; // Skip duplicates
                used[i] = true;
                tempList.add(arr.get(i));
                backtrack(result, arr, tempList, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
