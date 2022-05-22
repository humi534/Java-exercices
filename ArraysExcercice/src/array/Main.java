package array;

public class Main {

	public static void main(String[] args) {
		
		
		/*
		 * (b) Write a fragment of Java code that creates a 2-dimensional array of integers containing 100 rows, in which the 
		 * 1st, 3rd, 5th, . . . rows contain 1000 columns each, and the 2nd, 4th, 6th, . . . 
		 * ones contain 500 columns. The elements of the array can be left uninitialized.
		 */
		
		int[][] myArray = new int[100][];
		for(int i = 0; i<myArray.length; i++) {
			if(i%2 == 0) {
				myArray[i] = new int[500];
			}
			else {
				myArray[i] = new int[1000];
			}
		}
	}

}
