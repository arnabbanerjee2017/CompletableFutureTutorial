package com.arnab.completable.future.aync.noreturn;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(Thread.currentThread().getName());
		
		/**
		 * The below runAsync() method takes a Runnable and execute the run() method asynchronously.
		 * It runs in future and returns no value. Thus the return type is Void.
		 * You can check the thread name by the above print statement. It is main.
		 * Next inside the Lambda expression, there is another print statement to print the name of the thread.
		 * You can see that the name of the thread is ForJoinPool thread. So it is running in a separate thread from
		 * the ForkJoinPool. The last print statement is also there to print the current thread, which is the main thread.
		 */
		CompletableFuture<Void> cFuture = CompletableFuture.runAsync(() -> {
				System.out.println("In CompletableFuture");
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		});
		try {
			cFuture.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());
		long endTime = System.currentTimeMillis();
		long timeTaken = endTime - startTime;
		System.out.println("Time taken: " + timeTaken);
	}
	
}
