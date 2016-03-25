package beadando;

import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

public class Beadando {
	
	public static void tryTask1And2And3() {
		Signal<Integer> s = new Signal<>(0);
		Signal<Character> t = new Signal<>('y');
		
		/*
		s.setLastElement(1);
		t.setLastElement('x');*/
		
		Signal<Integer> x = s.map(a -> a + 1);
		Signal<Character> y = s.join(t, (a,b) -> b);
		Signal<Integer> z = t.accumulate((st,b) -> b=='y' ? st+1 : st, 0);
		
		System.out.println(x.getLastElement());
		System.out.println(y.getLastElement());
		System.out.println(z.getLastElement());
	}
	
	public static void tryTask4And5(long startTime) {
		TimeSignalSupplier ts = new TimeSignalSupplier();
		ts.every(1, TimeSteps.SECONDS, startTime);
		
		Timer exTimer = new Timer(true);
		exTimer.schedule(new TimerTask() {
			public void run() {
				ts.stopTimer();
			}
		}, 3000);
		try {
	        Thread.sleep(5000);
	    } catch(InterruptedException ie) {}
	}
	
	//6. feladat
	public static void tryTask6() {
		try {
			Signal<String> sig = new Signal<>("");
		    
		    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		    
		    while(!sig.getLastElement().equals("q")) {
		    	sig.setLastElement(bufferedReader.readLine());
		    	System.out.println(sig.getLastElement());
		    }
		} catch(Exception ex) { ex.printStackTrace(); }
	}
	
	//7. feladat
	public static void tryTask7(long startTime) {
		RunnableTimeThread rT1 = new RunnableTimeThread("TimeSignal", startTime);
		rT1.start();
		
		RunnableConsoleThread rT2 = new RunnableConsoleThread("ConsoleInSignal");
		rT2.start();
	}
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		//tryTask1And2And3();
		//tryTask4And5(startTime);
		//tryTask6();
		tryTask7(startTime);
	}
}
