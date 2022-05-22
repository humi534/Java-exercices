package Question1;

public class Main {

	public static void main(String[] args) {
		
		Interval int1 = new Interval(Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
		System.out.println(int1.toString());
		System.out.println(int1.isInRange(5));
		
		Interval int2 = new Interval(-5f, 5f);
		System.out.println(int2.toString());
		
	}

}
