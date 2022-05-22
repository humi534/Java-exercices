
public class Main {

	public static void main(String[] args) {

		IntSequence mySeq = new IntSequence(new int[] {2,1,5,4,7,8,2});
		System.out.println(mySeq.toString());
		IntSequence mySeq2 = mySeq.clone();
		
		System.out.println(mySeq.equals(mySeq2));
		try{
			int[] seq = mySeq.remove(2,4);
			printList(seq);
		}
		catch (IndexException e) {
			System.out.println(e.getMessage());
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("the indexes must correspond to the length of the sequence");
		}
		System.out.println(mySeq.equals(mySeq2));
		mySeq2.add(5);
		
		System.out.println(mySeq.toString());
		System.out.println(mySeq2.toString());
		
		
	}
	
	public static void printList(int[] seq) {
		System.out.print("seq: ");
		for (int i = 0; i < seq.length; i++)
			System.out.print(" " + seq[i]);
		System.out.print("\n");
	}

}
