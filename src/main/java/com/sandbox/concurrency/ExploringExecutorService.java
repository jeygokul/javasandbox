package com.sandbox.concurrency;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExploringExecutorService {

	public static void main(String[] args) {

		ExecutorService executorService = null;
		Runnable task1 = null;
		Runnable task2 = null;
		Runnable task3 = null;

		try {
			executorService = Executors.newFixedThreadPool(2);

			task1 = () -> {
				System.out.println("Time now : [ " + Thread.currentThread().getName() + " ]"
						+ Calendar.getInstance(TimeZone.getTimeZone("Asia/Singapore")).getTime());
			};

			task2 = () -> {
				try {
					TimeUnit.MINUTES.sleep(1);
				} catch (InterruptedException e) {
					System.err.println(Thread.currentThread().getName() + "was interrupted ");
				}
				System.out.println("Time now : [ " + Thread.currentThread().getName() + " ]"
						+ Calendar.getInstance(TimeZone.getTimeZone("Asia/Singapore")).getTime());
			};

			task3 = () -> {
				try {
					TimeUnit.MINUTES.sleep(3);
				} catch (InterruptedException e) {
					System.err.println(Thread.currentThread().getName() + "was interrupted ");
				}
				System.out.println("Time now : [ " + Thread.currentThread().getName() + " ]"
						+ Calendar.getInstance(TimeZone.getTimeZone("Asia/Singapore")).getTime());
			};
			
			executorService.submit(task1);
			executorService.submit(task2);
			executorService.submit(task3);
			
			executorService.shutdown();
			// Wait for 5 minutes and then terminate, but our task2 should
			// complete before it
			executorService.awaitTermination(5, TimeUnit.MINUTES);

		} catch (InterruptedException e) {
			System.err.println("One or more of the tasks has been interrupted");
		} finally {
			if (!executorService.isTerminated()) {
				System.err.println("Rollback or cancel tasks here");
			}
			//The shutdown() before this will shut down the executor, the below statement is of no use
			//But its here to understand the concepts
			//This will only get executed if our task2 runs more than 5 minutes as per the code
			executorService.shutdownNow();
			System.out.println("Forceful shutdown completed");
		}
	}

}
