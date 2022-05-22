package Question1;

public class Point implements Cloneable{
	private int X, Y, Z;
	
	public Point(int x, int y, int z) {
		this.X = x;
		this.Y = y;
		this.Z = z;
	}
	
	public synchronized int getX() {
		return this.X;
	}
	
	public synchronized int getY() {
		return this.Y;
	}
	
	public synchronized int getZ() {
		return this.Z;
	}
	
	public synchronized void translatePoint(int dx, int dy, int dz) {
		this.X += dx;
		this.Y += dy;
		this.Z += dz;
	}
	
	public synchronized boolean equals(Object u) {
		if(!(u instanceof Point))
			return false;
		
		Point s = (Point) u;
		return (this.X == s.X && this.Y == s.Y && this.Z == s.Z);
	}

	public synchronized int hashCode() {
		int hash = 1;
		hash = hash * 17 + this.X;
		hash = hash * 31 + this.Y;
		hash = hash * 13 + this.Z;
		return hash;
	}
	
	public synchronized Object clone() {
		Point copy;	
		try {
			copy = (Point) super.clone();
		} catch (CloneNotSupportedException e){
			throw new InternalError("unable to clone point");
		}
		return copy;
	}
	
	public synchronized String toString() {
		return "( "+ this.X + " , " + this.Y +" , " + this.Z +" )";
	}
}
