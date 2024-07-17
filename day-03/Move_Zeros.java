class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                count++;
            }else{
                list.add(nums[i]);
            }
        }
        for(int i = 0; i<nums.length; i++){
            if(i<list.size()){
                nums[i] = list.get(i);
            }else{
                nums[i] = 0;
            }
        }

    }
}