package Recursion;

public class Recursion {
    public static int getFactorial(int n) {
        if (n == 1) return 1;
        return n * getFactorial(n - 1);
    }

    public static int getFibonacciSequence(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return getFibonacciSequence(n - 1) + getFibonacciSequence(n - 2);
        }
    }
}
