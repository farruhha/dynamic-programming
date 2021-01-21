package easy;

public class FibonacciNumber {

    public int fib(int n) {
        if(n <= 1) return n;

        int n2 = 0;
        int n1 = 1;

        for(int index = 2; index <= n; index++){
            int last = n1 + n2;
            n2 = n1;
            n1 = last;
        }

        return n1;
    }
}
