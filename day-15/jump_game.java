class Solution {
    public boolean canJump(int[] nums) {
        if(rec(0, nums)>=1){
            return true;
        }
        return false;
    }
    public static int rec(int level, int[] nums){ // initialize with level 0, and the nums array

        int ans=0;
        //base case
        if(level == nums.length-1){
            //if i manage to reach the level equal to that means it is possible to reach there so return 1
            return 1;
        }
        //loop over choices
        for(int step=1; step<=nums[level]; step++){
            if(level+step<=nums.length-1){
                //check if it is a valid choice
                int ways = rec(level+step, nums);
                ans+=ways; 
            }
        }
        
        return ans;
        //current level ->index
        //chosices ->  0 to nums[index]
        //check if valid -> base case
        //move recurison call
    }
}