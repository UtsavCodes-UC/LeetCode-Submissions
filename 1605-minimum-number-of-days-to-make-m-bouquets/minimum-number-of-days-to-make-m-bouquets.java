class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long)m*k > n) return -1;

        int left = Integer.MAX_VALUE;
        int right =  Integer.MIN_VALUE;

        for(int d:bloomDay) {
            left = Math.min(left, d);
            right = Math.max(right, d);
        }

        while(left < right) {
            int mid = left + (right-left)/2;
            if (canMake(bloomDay, m, k, mid)) right = mid;
            else left = mid+1;
        }
        return left;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int days) {
        int run = 0;
        int bouquets = 0;
        for(int bloom : bloomDay) {
            if (bloom <= days) {
                run++;
                if (run == k) {
                    bouquets++; run=0;
                }
            }
            else run=0;
        }
        return bouquets >= m;
    }
}