

public class StackFullException extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackFullException(){
        super("La pile est pleine");
        }
}