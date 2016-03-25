package beadando;

import java.util.Timer;
import java.util.TimerTask;

//5. feladat
public class TimeSignalSupplier {
	
	private Timer timer = new Timer(true);
	
	public void every(int time, TimeSteps unit, long startTime) {
		Signal<Integer> sig = new Signal<>();
		sig.setAction(() -> System.out.println("Elapsed time: " + (System.currentTimeMillis() - startTime)));
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				sig.setLastElement(42);
			}
		}, time * unit.getTime(), time * unit.getTime());
	}
	
	public void stopTimer() { timer.cancel(); }

}
