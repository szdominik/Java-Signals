package beadando;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunnableConsoleThread extends RunnableThread implements Runnable {
	RunnableConsoleThread(String name) { super(name); }

	@Override
	public void run() {
		System.out.println("Running " +  super.threadName);
		
		Signal<String> sig = new Signal<>("");
	    
	    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	    try {
		    while(!sig.getLastElement().equals("q")) {
		    	sig.setLastElement(bufferedReader.readLine());
		    	System.out.println(sig.getLastElement());
		    }
	    } catch(Exception ex) {
	    	System.out.println("Thread " +  super.threadName + " interrupted.");
	    }
		/*
		try {
	        Thread.sleep(10000);
	    } catch(InterruptedException ie) {
	    	System.out.println("Thread " +  super.threadName + " interrupted.");
	    }*/
		
		System.out.println("Exiting " +  super.threadName );
	}

}
