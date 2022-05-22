package Question1;

public class Main {

	public static void main(String[] args){
		
		try {
			LineSegment segment = new LineSegment(1,1,1,1,1,1);
			System.out.println(segment.toString()); 
			LineSegment s = (LineSegment) segment.clone();
			s.translate(1, 1, 1);
			System.out.println(segment.toString());
			System.out.println(s.toString());
			
		
		} catch (NotValidException e) {
			System.out.println(e.getMessage());;
		} 
	}

}
