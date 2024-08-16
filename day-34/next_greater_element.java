class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            ans[i] = help(nums1[i], nums2);
        }
        return ans;
    }
    static int help(int x, int[] arr){
        int index =0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==x){
                index = i;
            }
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]>x && i>index ){
                return arr[i];
            }
        }
        return -1;
    }
}