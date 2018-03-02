package com.threadtest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadProblem  implements Runnable{
	
	private final Integer number;
	
	ThreadProblem(Integer number)
	{
		
		this.number=number;
	}
 
	
	@Override
	public void run() {
		
            System.out.println("thread number "+Thread.currentThread().getId()+" printing value "+number);
        }
	
		
	
	public static void main(String[] args) throws InterruptedException{
		
		ExecutorService executor = Executors.newFixedThreadPool(6);
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
		 //Runnable worker = new ThreadProblem();
		 //executor.execute(worker);
		 numbers.stream().forEach(x->{Runnable worker = new ThreadProblem(x);
		 executor.submit(worker);});
		 executor.shutdown();
	     try {
			executor.awaitTermination(10000, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
