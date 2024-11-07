import java.util.HashMap;
import java.util.Scanner;

public class Fibonacci {

    // Iterative Fibonacci method
    public static int fibonacciIterative(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            int[] dp = new int[n];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n - 1];
        }
    }

    // Recursive Fibonacci method with caching
    public static int fibonacciRecursive(int n) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        cache.put(1, 0);
        cache.put(2, 1);
        return helper(n, cache);
    }

    private static int helper(int n, HashMap<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            int result = helper(n - 1, cache) + helper(n - 2, cache);
            cache.put(n, result);
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value of n (nth Fibonacci number): ");
        int n = scanner.nextInt();

        System.out.println("Fibonacci Number (Iterative): " + fibonacciIterative(n));
        System.out.println("Fibonacci Number (Recursive): " + fibonacciRecursive(n));

        scanner.close();
    }
}

/*
 * OUTPUT:
 * 
 * Enter value of n (nth Fibonacci number): 5
 * Fibonacci Number (Iterative): 3
 * Fibonacci Number (Recursive): 3
 */