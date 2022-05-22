import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class IntSequence implements Cloneable, Serializable{
	
	private List<Integer> content;
	
	public IntSequence() {
		content = new ArrayList<>();
	}
	
	public IntSequence(int start) {
		this();
		content.add(start);
	}
	
	public IntSequence(String fileName) throws IOException {
		this();
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		try
		{
			int n = ((Integer) ois.readObject()).intValue();
			for (int i = 0; i < n; i++)
				content.add((Integer) ois.readObject());
		}
		catch (ClassNotFoundException e)
		{
			throw new IOException("Wrong stack format.");
		}
		
		finally {
			ois.close();
			fis.close();
		}
		
	}
	
	public IntSequence(int[] start) {
		this();
		for(int i = 0; i<start.length; i++) {
			content.add(start[i]);
		}
	}
	
	public synchronized void add(int i) {
		content.add(i);
	}
	
	public synchronized void add(int[] seq) {
		for(int i = 0; i < seq.length; i++) {
			content.add(seq[i]);
		}
	}
	
	public synchronized int remove(int index) throws IndexOutOfBoundsException{
		
		if (index<0 || index>this.content.size()) {
			throw new IndexOutOfBoundsException();
		}
		
		int nb = content.get(index);
		content.remove(index);
		
		return nb;
	}
	
	//Modifier de sorte que la valeur returned soit un IntSequence
	public synchronized int[] remove(int start, int end) throws IndexException, IndexOutOfBoundsException {
		if(start >= end)
            throw new IndexException("this first index must be smaller than the second one");
		
		if(start < 0 || end > this.content.size()) {
			throw new IndexOutOfBoundsException();
		}

		int[] seq = new int[end-start+1];
		int i, j;
        for( i = end, j = end-start; i>=start; i--, j--) {
        	seq[j] = this.content.get(i);
            this.content.remove(i);
        }
        return seq;
	}
	
	public synchronized IntSequence clone() {
		IntSequence copy;

        try{
            copy = (IntSequence) super.clone();
            copy.content = new ArrayList<Integer>();
            for (int i = 0; i<this.content.size(); i++){
                copy.content.add(this.content.get(i));
            }
        }
        catch (CloneNotSupportedException e){
            throw new InternalError("unable to clone");
        }
        return copy;
	}
	
	public synchronized boolean equals(Object u) {
		
		if(!(u instanceof IntSequence))
            return false;
		
		IntSequence s = (IntSequence) u;
		
		if (this.content.size() != s.content.size())
			return false;
		
		for (int i = 0; i < this.content.size(); i++) {
			if(!this.content.get(i).equals(s.content.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	public synchronized int hashCode(){
        int code = this.content.size();

        for (int i = 0; i<this.content.size(); i++){
            code += this.content.get(i).hashCode();
        }
        return code;
    }
	
	public void save(String fileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(Integer.valueOf(this.content.size()));
		for (int i = 0; i < this.content.size(); i++)
		oos.writeObject(this.content.get(i));
		oos.flush();
		oos.close();
		fos.close();
	}
	
	public synchronized String toString() {
		String s = "";
		for(int i = 0; i<this.content.size(); i++) {
			s += content.get(i).toString();
			s += " - ";
		}
		s = s.substring(0, s.length() - 3);
		return s;
	}
}
