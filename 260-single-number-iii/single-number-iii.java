class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int i=0; i<n; i++) {
            xor ^= nums[i];
        }
        int diff = xor & (-xor);
        int result[] = new int[2];
        for(int i=0; i<n; i++) {
            if ((nums[i]&diff) == 0) result[0] ^= nums[i];
            else result[1] ^= nums[i];
        }
        return result;
    }
}