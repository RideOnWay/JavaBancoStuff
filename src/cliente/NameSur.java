package cliente;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class NameSur {
	
	private String name ,surname , id ;
	private Scanner in = new Scanner(System.in);
	
	public void setName() {
		setName1();
		setSurname();
		setId();
		
	}
	
	public NameSur() {
		name = " ";
		surname = " ";
		id = " ";
	}
	
	private void setId() {
		if(id.equals(" ")) {
			System.out.println("Ingrese el numero de identificacion: ");
			id = in.next();
			noLetterOnId(id);
		}
	}
	
	private void noLetterOnId(String verify) {
		 
		 Pattern pat = Pattern.compile("[a-zA-Z]");
	     Matcher mat = pat.matcher(verify);   
	 		
	 			if(mat.find()) {
	 				System.out.println("El ID no puede contener letras");
	 				id = " ";
	 				setId();
	 			} 
	 }
	
	
	private void setName1() {
		if (name.equals(" ")) {
		    System.out.println("Ingrese el nombre: ");
		    name = in.next();
		    noNumberOnName(name);
		    this.name = setUpperCase(name);
		   
		}else {
			System.out.println("Ya tiene nombre.");
		}
	}
	
	private void setSurname() {
		
		if(surname.equals(" ")) {
			System.out.println("In surname: ");
			surname = in.next();
			noNumberOnSurname(surname);
			this.surname = setUpperCase(surname);
		}
	}
	
	private String setUpperCase(String word1) {
		  
		  String x = word1.toLowerCase();
		  String y = x.substring(1,word1.length());
		  
		  String a1 = x.substring(0, 1); 
		  String my = a1.toUpperCase();
		 
		  word1 = my.concat(y); 
		  
		  return word1;
		  
	}
	
	private void noNumberOnName(String verify ) {
		
		Pattern pat = Pattern.compile("[^A-Za-z]");
	     Matcher mat = pat.matcher(verify); 

			if(mat.find()) {
				name = " ";
				setName1();
			
			} 		
	}
	
	private void noNumberOnSurname (String g) {
		
		Pattern pat = Pattern.compile("[^A-Za-z]");
	     Matcher mat = pat.matcher(g); 

			if(mat.find()) {
				surname = " ";
				setSurname();
			
			} 		
	}
	
	public String getname() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getId() {
		return id;
	}
	
	public String toString() {
		
		return name + " " + surname;
	}
	

}
