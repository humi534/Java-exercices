package deep_copy;

public class Person implements Cloneable{
	
	public String name;
	private String firstname;
	public Address address;
	private int grade;
	
	public Person(String name, String firstname, Address address, int grade) {
		this.name = name;
		this.firstname = firstname;
		this.address = address;
		this.grade = grade;
	}
	
	public void setFirstname(String newFirstname) {
		this.firstname = newFirstname;
	}
	
	public void setAddress(Address newAddress) {
		this.address = newAddress;
	}
	
	//il semble que dans le cours et en ligne la methode clone renvoie toujours un Object
	/* shallow copy clone method: 
	 
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	*/
	
	//deep copy clone method:
	public Object clone() throws CloneNotSupportedException{
		Person newPerson = (Person)super.clone();
		newPerson.address = new Address(this.address.city, this.address.number);
		return newPerson;
	}
	
	
	
	public String toString() {
		String s = "";
		s += "name: " + this.name + "   firstname: " + this.firstname + "   grade: " + this.grade + "\naddress: " + this.address.toString() ;
		return s;
	}
}