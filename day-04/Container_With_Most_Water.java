class Solution {
    public int maxArea(int[] height) {
        int right = height.length-1;
        int left = 0;
        int currentHeight=0;
        int currentArea =0;
        int maxArea =0;
        while(left<right){
            currentHeight = Math.min(height[left],height[right]);
            currentArea = currentHeight*(right-left);
            maxArea = Math.max(currentArea, maxArea);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }

        }
        return maxArea;
    }
}