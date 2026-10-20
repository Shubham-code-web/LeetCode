class Solution {

    public static List<Integer> getdiv(int n) {
        List<Integer> res = new ArrayList<>();

        // Find all divisors of n (possible block sizes)
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                res.add(i);
                if (i != n / i) res.add(n / i);
            }
        }

        Collections.sort(res); // sort divisors
        return res;
    }

    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        List<Integer> divisors = getdiv(n);

        int ans = 0;

        // try each possible block size k
        for (int k : divisors) {

            int i = 0;
            int prevmax = 0;
            boolean flag = true;

            while (i < n) {

                int curmax = 0;
                int count = 0;

                // check boundary condition with previous block
                if (nums[i + k - 1] > nums[i]) count++;

                // invalid if current block goes below previous max
                if (prevmax > nums[i + k - 1]) {
                    flag = false;
                    break;
                }

                curmax = Math.max(curmax, nums[i + k - 1]);

                for (int j = i; j < i + k - 1; j++) {

                    // maintain global ordering constraint
                    if (prevmax > nums[j]) {
                        flag = false;
                        break;
                    }

                    curmax = Math.max(curmax, nums[j]);

                    // count local inversions inside block
                    if (nums[j] > nums[j + 1]) count++;
                }

                // more than one inversion → cannot be fixed by rotation
                if (count > 1) {
                    flag = false;
                    break;
                }

                prevmax = curmax; // update for next block
                i += k;           // move to next segment
            }

            if (flag) ans += k; // valid k contributes to answer
        }

        return ans;
    }
}