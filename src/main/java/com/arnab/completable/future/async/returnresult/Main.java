package com.arnab.completable.future.async.returnresult;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		/**
		 * The below supplyAsync() method takes a Supplier and execute the supply() method asynchronously.
		 * It runs in future and returns some value. Here the return type is String.
		 */
		CompletableFuture<String> cFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "I am running in Future.";
		});
		
		try {
			String result = cFuture.get();
			System.out.println(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		long timeTaken = endTime - startTime;
		System.out.println("Time taken: " + timeTaken);
	}
	
}
