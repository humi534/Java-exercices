package deep_copy;

public class main {
	
	/*
	 * Dans cet exemple, deux fonction clone() sont impl�ment�e pour la classe Person, la 1ere shallow copy, la 2eme deep copy.
	 * Pour le shallow copy, lorsque l'on change la variable nom d'une personne, cette variable
	 * se modifie uniquement pour cette person l� car il s'agit de variable "locale" (pas encore trouv� le mot correct)
	 * A l'inverse, lorsque l'on modifie une variable d'un objet (ici Address) qui est r�f�renc� dans l'objet principal (ici Person),
	 * on voit que l'adresse se modifie pour les 2 personnes car il s'agit d'un objet r�f�renc�. Afin de modifier l'adresse uniquement 
	 * pour une personne, il faut retravaill� la fonction clone() pour en faire un deep copy. 
	 */

	public static void main(String[] args){
		Address maison = new Address("Soree", 1);
		//Address andenne = new Address("Andenne", 5);
		Person hugo = new Person("Poncelet", "Hugo", maison, 20);
		
		
		Person isa = null;
		try {
			isa = (Person) hugo.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		
		isa.setFirstname("Isa");
		isa.name = "Streel";
		isa.address.city = "Andenne";
		
		System.out.println("hugo " + hugo.toString());
		System.out.println("isa " + isa.toString());
	}

}
