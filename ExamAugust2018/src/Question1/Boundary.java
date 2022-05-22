package Question1;

public class Boundary {
	
	private String bound;
	public Boundary(String a) {
		this.bound = a;
	}
	
	public float get() {
		if(bound.equals("negative infinity")){
			return Float.NEGATIVE_INFINITY;
		}
		else if(bound.equals("positive infinity")){
			return Float.POSITIVE_INFINITY;
		}
		
		return Float.parseFloat(bound);
	}
	
	public boolean isGreater(Boundary b) {
		return (this.get()>b.get());
	}
	
	public String toString() {
		return this.bound;
	}
}
