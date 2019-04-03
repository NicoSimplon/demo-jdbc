package dev.demo_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// DriverManager.registerDriver(new Driver());
		// Etape 1 - Chargement du pilote
		Class.forName("com.mysql.jdbc.Driver");
		
		// Etape 2 - Définition de la JDBC URL
		String jdbcUrl = "jdbc:mysql://localhost:3306/bdd_mysql";
		
		// Etape 3 - Création de la connexion
		Connection uneConnexion = DriverManager.getConnection(jdbcUrl, "root", "");
		
		Statement st = uneConnexion.createStatement();
		
		// Etape 4 - exécution  de la requête
		ResultSet rs = st.executeQuery("select * from employes");
		
		// Etape 5 - exploitation des résultats
		while(rs.next()) {
			
			int id = rs.getInt("NO_EMPLOYE");
			String titre = rs.getString("NOM");
			
			System.out.println("NO_EMPLOYE=" + id + " NOM=" + titre);
		}

		// Etape 6 - Fermeture des ressources
		rs.close();
		
		st.close();
		
		uneConnexion.close();

	}

}