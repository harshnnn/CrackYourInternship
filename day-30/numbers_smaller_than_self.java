class Solution {
    void merge(int low,int mid,int high,vector<pair<int,int>>& arr, vector<int>& ans){
        vector<pair<int,int>> temp(high-low+1);

        int i = low;
        int j = mid+1;
        int k = 0;


        while(i<=mid && j<=high){
            if(arr[i].first <= arr[j].first){
                temp[k++] = arr[j++];
            }
            else{
                ans[arr[i].second] += (high-j+1);
                temp[k++] = arr[i++];
            }
        }

        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=high){
            temp[k++] = arr[j++];
        }

        for(int a = low ; a<=high ; a++){
            arr[a] = temp[a-low];
        }
    }


    void help(int s,int e, vector<pair<int,int>>& arr, vector<int>& ans){
        if(s>=e){
            return;
        }
        int mid = (e-s)/2+s;
        help(s,mid,arr,ans);
        help(mid+1,e,arr,ans);

        merge(s,mid,e,arr,ans);
    }
public:
    vector<int> countSmaller(vector<int>& nums) {
        vector<pair<int,int>> arr;
        for(int i = 0 ; i<nums.size(); i++){
            arr.push_back({nums[i],i});
        }
        vector<int> ans(nums.size(),0);
        help(0,nums.size()-1,arr, ans);

        return ans;
    }
};