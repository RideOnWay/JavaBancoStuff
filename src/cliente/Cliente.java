package cliente;

import java.io.Serializable;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 8138274017650705211L;
	
	private String name,surname, id, acount; 
	
	public static ArrayList<Cliente> clientes = new ArrayList<>();
	
	// constructor
	public Cliente(NameSur name , AcountConfig acount) {
		
	    	this.name = name.getname();
	    	this.surname = name.getSurname();
	    	this.id = name.getId();
	    	this.acount = acount.getAct();
	    	clientes.add(0,this);
	}

	public String toString() {
		
		return name + " " +surname + " " + id + " " +  acount + " " ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAcount() {
		return acount;
	}

	public void setAcount(String acount) {
		this.acount = acount;
	}

	
	
	
	
	
	
//     public static String getClientes() {
//		
//        for(Object x : clientes ) {
//        	
//        	System.out.println(x.toString());
//         }
//	         return " =List ";	    
//	}
//	
}
