class Solution {
public:
    int minMergedInteger(vector<int>& nums) {
        int i=0;
        int ans=INT_MAX;
        int num=-1;
        while(i<nums.size()){
            string s="";
            s+=to_string(nums[i]);
            s+=to_string(nums[i+1]);
            num=stoi(s);
            ans=min(ans,num);
            i=i+2;
        }
        return ans;
    }
};