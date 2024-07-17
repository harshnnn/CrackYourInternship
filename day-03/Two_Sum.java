class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hmap.containsKey(complement) && hmap.get(complement) != i) {
                ans[0] = i;
                ans[1] = hmap.get(complement);
                return ans;
            }
            hmap.put(nums[i], i);
        }
        return ans;
    }
}
