package cliente;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcountConfig {
	
	private String  numberAcount = " ";
	private double balance, interestType;
	private Scanner in = new Scanner(System.in);
	
	
	public void setAcount() {
		setAcountTrue();
		setAcountlenght();
		onlyNumbers(numberAcount);
		setAcountNumber();
		
	}
	
	private void setAcountTrue(){
	
		if(numberAcount.equals(" ")) {
			System.out.println("Ingresa el numero de cuenta.");
			numberAcount = in.next();
			
		}else {
			System.out.println("cuente ya creada");
			
		}
	}
	
	private void setAcountlenght() {
		if(numberAcount.length() != 8) {
			System.out.println("La cuente debe ser de 8 digitos.");
			numberAcount = " ";
			setAcount();
			
		}
	}
	
	private void setAcountNumber(){
		long aux = Long.valueOf(numberAcount);
		if(aux <= 99999999 && aux >= 01000000) {
			String p = Long.toString(aux);
			this.numberAcount = p;
		}else {
			System.out.println("Numero de cuenta invalida.");
			numberAcount = " ";
			setAcount();
			
		}
	}
	
	private void onlyNumbers(String verify ) {
		
		Pattern pat = Pattern.compile("[^0-9]");
	     Matcher mat = pat.matcher(verify); 

			if(mat.find()) {
				numberAcount = " ";
				setAcount();
			
			} 		
	}
	
	public String getAct() {
		return numberAcount;
	}
	
	public double getInty() {
		return interestType;
	}
	
	public String getBal() {
		return "the balance is " + balance;
	}
	
	
	public void setBala(double bal) {
		
		balance += bal;
	}
	
	public void setinTy() {
		
		System.out.println("Ingrese  el interes: ");
		interestType =  in.nextDouble();
		
	}
	
	
//	public static void transferencia(Cliente give, Cliente receive, int amount) {
//		
//		if (amount > 0 && amount < give.balance) {
//			give.balance -= amount;
//			receive.balance += amount;
//		}else {
//			System.out.println("Transaccion no exitosa.");
//		}
//	}

}
