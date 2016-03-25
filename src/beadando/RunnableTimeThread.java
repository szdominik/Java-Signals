package beadando;

import java.util.Timer;
import java.util.TimerTask;

public class RunnableTimeThread extends RunnableThread implements Runnable {
	private long startTime;
	
	RunnableTimeThread(String name, long startTime) { super(name); this.startTime = startTime; }

	@Override
	public void run() {
		System.out.println("Running " +  super.threadName );
		
		TimeSignalSupplier ts = new TimeSignalSupplier();
		ts.every(1, TimeSteps.SECONDS, this.startTime);
		
		//9 másodpercig működik (hogy egyszer vége legyen...)
		Timer exTimer = new Timer(true);
		exTimer.schedule(new TimerTask() {
			public void run() {
				ts.stopTimer();
			}
		}, 9000);
		
		//legalább 10 másodpercig működjön.
		try {
	        Thread.sleep(10000);
	    } catch(InterruptedException ie) {
	    	System.out.println("Thread " +  super.threadName + " interrupted.");
	    }
		
		System.out.println("Exiting " +  super.threadName );
	}

}
