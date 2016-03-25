package beadando;

public class RunnableThread implements Runnable {
	protected Thread t;
	protected String threadName;
	
	RunnableThread(String name) { this.threadName = name; }
	
	public void run() { }
	
	public void start() {
		if(t == null) {
			t = new Thread (this, threadName);
			t.start();
		}
	}

}
