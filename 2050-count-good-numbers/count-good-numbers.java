class Solution {
    long MOD = 1000000007L;
    public int countGoodNumbers(long n) {
        if (n%2==0) return (int)((power(5L, n/2) * power(4L, n/2)) % MOD);
        else return (int)((power(5L, n/2 + 1) * power(4L, n/2)) % MOD);
    }

    public long power(long a, long b) {
        long ans = 1;

        while (b > 0) {
            if (b % 2 == 1) {
                ans = (ans * a) % MOD;
            }

            a = (a * a) % MOD;
            b /= 2;
        }

        return ans;
    }
}