class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int j=0; j<32; j++) {
            int countOnes = 0;
            for(int i=0; i<n; i++) {
                countOnes += nums[i] >> j & 1;
            }
            countOnes%=3;
            ans |= (countOnes << j);
        }
        return ans;
    }
}