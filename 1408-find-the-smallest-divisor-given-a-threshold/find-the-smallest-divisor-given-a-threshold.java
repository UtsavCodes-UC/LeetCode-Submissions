class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int left = 1;
        int right = 0;
        for(int num : nums) right = Math.max(right, num);

        while(left < right) {
            int mid = left + (right - left)/2;
            if (underThreshold(nums, threshold, mid)) right = mid;
            else left = mid+1;
        }
        return left;
    }

    private boolean underThreshold(int[] nums, int threshold, int divisor) {
        int t = 0;
        for(int num : nums) {
            t += Math.ceilDiv(num, divisor);
        }
        return t <= threshold;
    }
}