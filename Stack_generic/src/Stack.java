
import java.util.ArrayList;
import java.util.List;

public class Stack <T>
{
    private final static int max = 5;
    private int nbElements;
    private List<T> content;

    public Stack(){
        nbElements = 0;
        content = new ArrayList<T>();
    }

    public void push(T newElement) throws StackFullException{
        if(nbElements >= max){
            throw new StackFullException();
        }
        else{
            content.add(newElement);
            nbElements++;
        }
    }

    public T pop() throws StackEmptyException{
    	if(nbElements == 0) {
    		throw new StackEmptyException();
    	}
    	
    	else {
	        T lastElement = content.get(nbElements-1);
	        content.remove(nbElements-1);
	        nbElements--;
	        return lastElement;
    	}
    }

    public String toString(){
        String s = "Stack: [";
        for (int i = 0; i < nbElements; i++){
            s += this.content.get(i);
            s += " ";
        }
        s += "]";
        return s;
    }

}