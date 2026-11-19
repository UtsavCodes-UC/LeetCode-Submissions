class Solution {
    public int splitArray(int[] nums, int k) {
        int start = nums[0];
        int end = 0;

        for(int num : nums) {
            start = Math.max(start, num);
            end += num;
        }

        while(start < end) {
            int mid = start + (end - start) / 2;
            if (split(nums, k, mid)) end = mid;
            else start = mid+1;
        }
        return end;
    }

    private boolean split(int[] nums, int k, int sum) {
        int count = 0;
        int parts = 1;
        for(int num : nums) {
            if (count + num > sum) {
                count = num;
                parts++;
            }
            else count += num;
        }
        return parts <= k;
    }
}