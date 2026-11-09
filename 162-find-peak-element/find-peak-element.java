class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        if (n==1) return 0;
        if (nums[1] < nums[0]) return 0;
        if (nums[n-2] < nums[n-1]) return n-1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if ((mid==0 || nums[mid]>nums[mid-1]) && (mid==n-1||nums[mid]>nums[mid+1])) return mid;
            else if (mid>0 && nums[mid] < nums[mid-1]) right = mid-1;
            else left = mid+1;
        }

        return -1;
    }
}