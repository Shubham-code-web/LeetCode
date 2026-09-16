class Solution {
    public int numberOfSets(int n, int k) {
        int N = n + k - 1;
        int R = 2 * k;
        
        // nCr optimization: C(N, R) == C(N, N - R)
        if (R > N) return 0;
        if (R > N - R) {
            R = N - R;
        }
        
        long num = 1;
        long den = 1;
        long MOD = 1_000_000_007;
        
        for (int i = 1; i <= R; i++) {
            num = (num * (N - i + 1)) % MOD;
            den = (den * i) % MOD;
        }
        
        // Divide num by den using Fermat's Little Theorem for modular inverse
        return (int) ((num * modularInverse(den, MOD)) % MOD);
    }
    
    private long modularInverse(long n, long prime) {
        return power(n, prime - 2, prime);
    }
    
    private long power(long base, long exp, long prime) {
        long res = 1;
        base %= prime;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % prime;
            }
            base = (base * base) % prime;
            exp >>= 1;
        }
        return res;
    }
}