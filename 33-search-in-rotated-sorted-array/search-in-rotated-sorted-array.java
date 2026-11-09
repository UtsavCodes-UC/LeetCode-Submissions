class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        boolean firstPart = (target >= nums[0]);
        int pivot = 0;
        while(left <= right) {
            int mid = (left+right)/2;
            if (mid+1<n && nums[mid] > nums[mid+1]) {
                pivot = mid;
                break;
            }
            else if (nums[mid] == nums[left]) {
                pivot = right;
                break;
            }
            else {
                if (nums[mid] > nums[left]) left = mid+1;
                else right = mid-1;
            }
        }

        if (firstPart) {
            left = 0;
            right = pivot;
            while(left <= right) {
                int mid = (left+right)/2;
                if (nums[mid] == target) return mid;
                else if (nums[mid] > target) right = mid-1;
                else left = mid+1;
            }
        }
        else {
            left = pivot+1;
            right = n-1;
            while(left <= right) {
                int mid = (left+right)/2;
                if (nums[mid] == target) return mid;
                else if (nums[mid] > target) right = mid-1;
                else left = mid+1;
            }
        }
        return -1;
    }
}