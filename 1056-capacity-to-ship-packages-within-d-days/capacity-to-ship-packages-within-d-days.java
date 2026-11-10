class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int sum=0;
        int max=0;
        for(int weight : weights) {
            sum+=weight;
            max = Math.max(max, weight);
        }
        int left = max;
        int right = sum;

        while(left <= right) {
            int mid = left + (right-left)/2;
            if (canShip(weights, mid, days)) right = mid-1;
            else left = mid+1;
        }
        return left;
    }

    private boolean canShip(int[] weights, int capacity, int days) {
        int sum=0;
        int d=1;
        for(int weight : weights) {
            sum += weight;
            if (sum > capacity) {
                sum = weight;
                d++;
            }
        }
        return d <= days;
    }
}