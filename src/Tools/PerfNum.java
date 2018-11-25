package Tools;

public class PerfNum {

    /**
     * Return true if n is a perfect number.
     *
     * @param n - number to prove
     * @return {@code true} if {@param n} is a perfect number
     */
    public static boolean isPerfect(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        return sum == n;
    }
}