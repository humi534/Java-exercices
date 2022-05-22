package Question1;
public class Interval {
	
	private final Boundary a, b;
	private static final long serialVersionUID = 125465126165L;
	
	
	public Interval(String param1, String param2) throws NotValidInputException {
		
		Boundary bound1 = new Boundary(param1); 
		Boundary bound2 = new Boundary(param2);
		
		if (bound1.isGreater(bound2))
			throw new NotValidInputException("input a must be smaller than input b");
		
		this.a = new Boundary(param1); 
		this.b = new Boundary(param2);
	}
	
	
	public synchronized float getA() {
		return this.a; 
	}
	
	public synchronized float getB() {
		return this.b;
	}
	
	public synchronized boolean contains(float x) {
		return ((this.a <= x) && (this.b >= x));
	}
	
	public synchronized boolean contains(Interval interval) {
		return (this.a <= interval.getA() && interval.getB() <= this.b );
	}
	
	public synchronized boolean isFinite() {
		return (!(this.a == Float.NEGATIVE_INFINITY) || (this.b == Float.NEGATIVE_INFINITY));
	}
	// • It must be possible to compute (as a newly created interval) the smallest interval that contains two given intervals.
	
	
	public float max(float a, float b) {
		return (a>b) ? a : b ;
	}
	
	public float min(float a, float b) {
		return (a<b) ? a : b ;
	}
	
	public synchronized Interval smallestInterval(Interval int1, Interval int2) {
		float min, max; 
		
		min = min(int1.getA(), int2.getA());
		max = max(int1.getB(), int2.getB());
		
		Interval newInt = null;
		
		try {
			if(min == Float.NEGATIVE_INFINITY && max == Float.POSITIVE_INFINITY)
				newInt = new Interval("negative infinity", "positive infinity");
			if(min == Float.NEGATIVE_INFINITY && max != Float.POSITIVE_INFINITY)
				newInt = new Interval("negative infinity", (int)max);
			if(min != Float.NEGATIVE_INFINITY && max == Float.POSITIVE_INFINITY)
				newInt = new Interval((int)min, "positive infinity");
			if(min != Float.NEGATIVE_INFINITY && max != Float.POSITIVE_INFINITY)
				newInt = new Interval((int)min, (int)max);
		} catch (NotValidInputException e) {
			;
		}
		
		return newInt;
	}
	
	public String toString() {
		return "[ " + this.a + " ; "+this.b + " ]"; 
	}
}

