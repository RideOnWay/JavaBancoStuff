package cliente;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;



public class Main {

	public static void main(String[] args) {
		
		String cliente;
	
		NameSur name = new NameSur();
		name.setName();
		
		AcountConfig acount = new AcountConfig();
		acount.setAcount();
		Cliente customer = new Cliente(name,acount);

		
//		NameSur name1 = new NameSur();
//		name1.setName();
//		
//		AcountConfig acount1 = new AcountConfig();
//		acount1.setAcount();
//		Cliente customer1 = new Cliente(name1,acount1);

//		System.out.println("Datos del cliente:  " + customer.toString() + " "+  acount.getBal() + "   interes: "+ acount.getInty());
//		System.out.println("Datos del cliente:  " + customer1.toString() + " "+  acount1.getBal() + "   interes: "+ acount1.getInty());
		
		
//		for(int i = 0 ; i < Cliente.clientes.size(); i++) {
//		System.out.println(Cliente.clientes.get(i).toString());
//		}
	
//		System.out.println(customer.clientes.toString());
//		System.out.println(customer1.clientes.toString());

		cliente = customer.getId() + " " + customer.getName() + " " + customer.getSurname() + " " +customer.getAcount();
		
		new connectMySql().setDB(cliente);
		
		
	}

}

 class connectMySql{
	
	 	String baseDeDatos = "mybank";
		String usuario = "root";
		String password = "";
		String host = "localhost";
		String puerto = "3302";
		String driver = "com.mysql.jdbc.Driver";
		String cnx1 = "jdbc:mysql://localhost";
		
		
		void showDB(){
			Connection conn = null;

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn= DriverManager.getConnection(cnx1,usuario,password);
				Statement  miEstado = conn.createStatement();
				ResultSet resultado = miEstado.executeQuery("use mybank"	);
				resultado = miEstado.executeQuery("select * from datospersonales"	);

				while(resultado.next()) {
					System.out.println(resultado.getString("nombre") + resultado.getString("Id"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		public void setDB(String cliente) {
			
			Connection conn = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn= DriverManager.getConnection(cnx1,usuario,password);
				Statement  miEstado = conn.createStatement();
				String instruccion = "INSERT INTO mybank VALUES ";
				miEstado.executeQuery(instruccion.concat(cliente));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}

