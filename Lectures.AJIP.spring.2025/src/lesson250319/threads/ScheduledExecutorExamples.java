package lesson250319.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import utils.Utils;

public class ScheduledExecutorExamples {
	
	public static void main(final String[] args) {
		
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		
		/*
		 *   ---!---!---!
		 *   [   ]---[   ]
		 */
		
//		service.schedule(() -> {
//			System.out.println("hi there!");
//		}, 4, TimeUnit.SECONDS);
//		
//		service.scheduleAtFixedRate(() -> {
//			System.out.println("hello from " + Thread.currentThread());
//		}, 0, 2, TimeUnit.SECONDS);
		
		service.scheduleWithFixedDelay(() -> {
			System.out.println("enter");
			Utils.pause(2000);
			System.out.println("exit");
		}, 0, 3, TimeUnit.SECONDS);
		
	}

}
