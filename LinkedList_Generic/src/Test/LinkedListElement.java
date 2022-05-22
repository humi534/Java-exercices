package Test;

public class LinkedListElement<T> {
	
	private T value;
	private LinkedListElement<T> next;
	
	public LinkedListElement(T value, LinkedListElement<T> next) {
		this.value = value;
		this.next = next;
	}
	
	public T getValue() {
		return value;
	}
	
	public LinkedListElement<T> getNext(){
		return next;
	}
	
}
