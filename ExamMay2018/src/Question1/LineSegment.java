package Question1;

import java.io.*;

public class LineSegment implements Cloneable, Serializable {
	
	private static final long serialVersionUID = 17564864684564568L;
	private Point p1, p2;
	
	public LineSegment(int x1, int y1, int z1, int x2, int y2, int z2) throws NotValidException  {
		this.p1 = new Point(x1,y1,z1);
		this.p2 = new Point(x2,y2,z2);
		
		if(p1.equals(p2))
			throw new NotValidException("P1 and P2 must be different");
	}
	
	@SuppressWarnings("resource")
	public LineSegment(String fileName) throws IOException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		try {
			int x1 = ((Integer) ois.readObject()).intValue();
			int y1 = ((Integer) ois.readObject()).intValue();
			int z1 = ((Integer) ois.readObject()).intValue();
			int x2 = ((Integer) ois.readObject()).intValue();
			int y2 = ((Integer) ois.readObject()).intValue();
			int z2 = ((Integer) ois.readObject()).intValue();

			this.p1 = new Point(x1,y1,z1);
			this.p2 = new Point(x2,y2,z2);
			
		} catch (ClassNotFoundException e) {
			throw new IOException("Wrong LineSegment format");
		}
		
		ois.close();
		fis.close();
		
	}
	
	public synchronized  void save (String fileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(Integer.valueOf(this.p1.getX()));
		oos.writeObject(Integer.valueOf(this.p1.getY()));
		oos.writeObject(Integer.valueOf(this.p1.getZ()));
		oos.writeObject(Integer.valueOf(this.p2.getX()));
		oos.writeObject(Integer.valueOf(this.p2.getY()));
		oos.writeObject(Integer.valueOf(this.p2.getZ()));
		
		oos.flush();
		oos.close();
		fos.close();
	}
	
	public synchronized void translate(int dx, int dy, int dz) {
		p1.translatePoint(dx, dy, dz);
		p2.translatePoint(dx, dy, dz);
	}
	
	public synchronized String toString() {
		return "[ "+this.p1 + " ; " + this.p2 +" ]"; 
	}
	
	public synchronized LineSegment[] split() {
		Point m = new Point( (p1.getX()+p2.getX())/2 , (p1.getY()+p2.getY())/2 , (p1.getZ()+p2.getZ())/2 );
		LineSegment[] newSegments = new LineSegment[2]; 
		
		try {
			newSegments[0] = new LineSegment(p1.getX(), p1.getY(), p1.getZ(), m.getX(), m.getY(), m.getZ());
			newSegments[1] = new LineSegment(m.getX(), m.getY(), m.getZ(), p2.getX(), p2.getY(), p2.getZ());
		} catch (NotValidException e) {
			System.out.println("La fonction split génère 2 points identiques");
		} 
		return newSegments; 	
	}
	
	public synchronized boolean equals (Object u) {
		if (!(u instanceof LineSegment))
			return false;
		
		LineSegment s = (LineSegment) u;
		
		return (this.p1.equals(s.p1) && this.p2.equals(s.p2));
	}
	
	public synchronized int hashCode() {
		int hash = 1;
		hash = hash * 17 + this.p1.hashCode();
		hash = hash * 31 + this.p2.hashCode();
		return hash;
	}
	
	
	public synchronized Object clone() {
		LineSegment copy;
		try {
			copy = (LineSegment) super.clone();
			copy.p1 = (Point) this.p1.clone();
			copy.p2 = (Point) this.p2.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError("unable to clone lineSegment");
		}
		return copy;
	}
	
	
}





