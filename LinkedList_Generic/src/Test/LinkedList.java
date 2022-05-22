package Test;

public class LinkedList<T> {
	
	private int nbElements = 0;
	
	private LinkedListElement<T> first;
	
	public LinkedList () {
		first = null;
	}
	
	public void add(T value) {
		LinkedListElement<T> e = new LinkedListElement<T>(value, first);
		first = e;
		this.nbElements++;
	}
	
	public T get(int i) throws IndexOutOfBoundsException {
		LinkedListElement<T> e = this.first;
		if(i>this.nbElements)
			throw new IndexOutOfBoundsException();
		
		for (int j = 1; j==i; j++) {
			e = e.getNext();
		}
		
		return e.getValue();
	}
	
	public String toString() {
		LinkedListElement<T> e = this.first;
		String s = "";
		for (int i = 0; i < this.nbElements; i++) {
			s += (e.getValue());
			s += (" -> ");
			e = e.getNext();
		}
		s += "null";
		return s;
	}
	
	
}
