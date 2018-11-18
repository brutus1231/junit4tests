package pl.sda;

public class FibonacciChain {

    Integer calculate(Integer n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        else if (n == 0) return 0;
        else if (n <= 2) return 1;

        int lastElement = 1;
        int prevLastElement = 1;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = lastElement + prevLastElement;
            prevLastElement = lastElement;
            lastElement = result;
        }
        return result;
    }
}
