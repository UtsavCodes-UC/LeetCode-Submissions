import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int lo = 1, hi = position[n - 1] - position[0];

        while (lo < hi) {                         
            int mid = lo + (hi - lo + 1) / 2;  
            if (canPlace(position, m, mid)) lo = mid;  
            else hi = mid - 1;                    
        }
        return lo;
    }

    private boolean canPlace(int[] p, int m, int d) {
        int count = 1, last = p[0];          
        for (int i = 1; i < p.length; i++) {
            if (p[i] - last >= d) {
                count++;
                last = p[i];
                if (count == m) return true;
            }
        }
        return count >= m;
    }
}