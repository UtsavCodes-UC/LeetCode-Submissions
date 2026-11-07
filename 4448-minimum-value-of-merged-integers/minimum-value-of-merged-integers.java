class Solution {
    public int minMergedInteger(int[] nums) {
        int n= nums.length;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i+=2) {
            int len = String.valueOf(nums[i+1]).length();
            min = (int) Math.min(min, nums[i]*Math.pow(10, len) + nums[i+1]);
        }
        return min;
    }
}