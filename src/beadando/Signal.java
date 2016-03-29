package beadando;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Signal<T> {
	//1. feladat
	private T lastElement;
	private List<Action> actions = new ArrayList<>();
	
	public void setAction(Action act) { this.actions.add(act); }
	
	public T getLastElement() { return lastElement; }
	public void setLastElement(T value) {
		this.lastElement = value;
		if(this.actions.size() != 0)
			this.actions.forEach(act -> act.run());
	}
	
	//2. feladat
	Signal() { }
	Signal(T value) { this.lastElement = value; }
	
	//3. feladat
	public Signal<T> map(Function<T, T> mapFunc) {
		Signal<T> newSig = new Signal<>(mapFunc.apply(lastElement));
		this.actions.forEach(act -> newSig.setAction(act));
		return newSig;
	}
	
	public <B, C> Signal<C> join(Signal<B> t, BiFunction<T, B, C> joinFunc) {
		Signal<C> newSig = new Signal<>(joinFunc.apply(this.lastElement, t.lastElement));
		this.actions.forEach(act -> newSig.setAction(act));
		t.actions.forEach(act -> newSig.setAction(act));
		return newSig;
	}
	
	public <B> Signal<B> accumulate(BiFunction<B, T, B> accFunc, B start) {
		Signal<B> newSig = new Signal<>(accFunc.apply(start, this.lastElement));
		this.actions.forEach(act -> newSig.setAction(act));
		return newSig;
	}	
	
}
