package beadando;

import java.util.function.*;

public class Signal<T> {
	//1. feladat
	private T lastElement;
	private Action action;
	
	public void setAction(Action act) { this.action = act; }
	
	public T getLastElement() { return lastElement; }
	public void setLastElement(T value) {
		this.lastElement = value;
		if(this.action != null)
			this.action.run();
	}
	
	//2. feladat
	Signal() { }
	Signal(T value) { this.lastElement = value; }
	
	//3. feladat
	public Signal<T> map(Function<T, T> mapFunc) {
		return new Signal<>(mapFunc.apply(lastElement));
	}
	
	public <B> Signal<B> join(Signal<B> t, BiFunction<T, B, B> joinFunc) {
		return new Signal<>(joinFunc.apply(this.lastElement, t.lastElement));
	}
	
	public <B> Signal<B> accumulate(BiFunction<B, T, B> accFunc, B start) {
		return new Signal<>(accFunc.apply(start, this.lastElement));
	}
	
	
}
