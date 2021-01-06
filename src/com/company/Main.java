package com.company;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        LocalTime startTime, endTime;

        startTime = LocalTime.now();
        ForkJoinFibonacci forkJoinFibonacci = new ForkJoinFibonacci(50);
        new ForkJoinPool().invoke(forkJoinFibonacci);
        endTime = LocalTime.now();
        long forkJoinResult = forkJoinFibonacci.getNumber();
        long forkJoinTime = (endTime.getLong(ChronoField.MILLI_OF_DAY)
                - startTime.getLong(ChronoField.MILLI_OF_DAY));

        startTime = LocalTime.now();
        long recursiveResult = ForkJoinFibonacci.findFibonacciNumber(50);
        endTime = LocalTime.now();
        long recursiveTime = (endTime.getLong(ChronoField.MILLI_OF_DAY)
                - startTime.getLong(ChronoField.MILLI_OF_DAY));

        System.out.println("ForkJoinPool result (50th number): " + forkJoinResult); //12586269025
        System.out.println("ForkJoinPool time result: " + forkJoinTime);
        System.out.println("\nRecursive result (50th number): " + recursiveResult); //12586269025
        System.out.println("Recursive time result: " + recursiveTime);
    }
}
