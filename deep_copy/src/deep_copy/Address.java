package deep_copy;

public class Address {
	
	public String city;
	public int number;
	
	public Address(String city, int number) {
		this.city = city;
		this.number = number;
	}
	
	public String toString() {
		String s = "";
		s += "city: " + this.city + "   number: " + this.number;
		return s;
	}
}
