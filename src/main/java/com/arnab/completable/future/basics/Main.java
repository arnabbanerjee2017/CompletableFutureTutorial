package com.arnab.completable.future.basics;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
	public static void main(String[] args) {
		CompletableFuture<String> cFuture = new CompletableFuture<String>();
		String result = null;
		try {
			/**
			 * The below cFuture.get() will block permanently. 
			 * As there is nothing to execute and it will wait till any execution or value.
			 */
			//result = cFuture.get();
			
			/**
			 * The below cFuture.complete("Some value") will manually complete the thread/execution by providing the String value.
			 * Hence it will not block.
			 */
			cFuture.complete("Some value");
			result = cFuture.get();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println(result);
	}
}
