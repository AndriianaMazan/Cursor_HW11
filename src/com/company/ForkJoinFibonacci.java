package com.company;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoinFibonacci extends RecursiveAction {
    private volatile long number;
    private static final long threads = 25;

    public ForkJoinFibonacci(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    @Override
    protected void compute() {
        long n = number;
        if (n <= threads) {
            number = findFibonacciNumber(n);
        } else {
            ForkJoinFibonacci fibonacci1 = new ForkJoinFibonacci(n - 1);
            ForkJoinFibonacci fibonacci2 = new ForkJoinFibonacci(n - 2);
            ForkJoinTask.invokeAll(fibonacci1, fibonacci2);
            number = fibonacci1.number + fibonacci2.number;
        }
    }

    public static long findFibonacciNumber(long n){
        if (n <= 1){
            return n;
        } else {
            return findFibonacciNumber(n - 1) + findFibonacciNumber(n - 2);
        }
    }
}
