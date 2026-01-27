public class BackWardsPrime {
​
    public static String backwardsPrime(long start, long end) {
        StringBuilder result = new StringBuilder();
​
        for (long i = start; i <= end; i++) {
            if (isPrime(i)) {
                long reversed = reverse(i);
                if (reversed != i && isPrime(reversed)) {
                    result.append(i).append(" ");
                }
            }
        }
​
        return result.toString().trim();
    }
​
    private static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
​
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
​
    private static long reverse(long n) {
        long reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + (n % 10);
            n /= 10;
        }
        return reversed;
    }
}
​