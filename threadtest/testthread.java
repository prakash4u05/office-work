

package com.threadtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class testthread implements Runnable {
	
	private final long countUntil;
	
	private  static int counterthread =0;
	
	testthread (long countUntil) {
        this.countUntil = countUntil;
    }
	
	@Override
	public void run()
	{
		long sum = 0;
        for (long i = 1; i < countUntil; i++) {
            sum += i;
        }
        long counterthread = Thread.currentThread().getId();
        System.out.println("thread number "+ (counterthread-8) + ": "+ sum);
	}
	private static final int NTHREDS = 5;

	public static void main (String[] args) throws InterruptedException
	{
		ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new testthread(500+i);
            executor.execute(worker);
        }
        executor.shutdown();
        executor.awaitTermination(10000, TimeUnit.NANOSECONDS);
        System.out.println("Finished all threads");
	}

}
