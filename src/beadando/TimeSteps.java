package beadando;

//4. feladat
public enum TimeSteps {
	SECONDS(1000), MILISEC(1), MINUTES(60000);
	
	private int timeInMs;
	
	TimeSteps(int time) { this.timeInMs = time; }
	
	public int getTime() { return this.timeInMs; }
}
