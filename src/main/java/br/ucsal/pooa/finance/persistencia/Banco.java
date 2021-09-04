package br.ucsal.pooa.finance.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco {
	
	private Connection conexao;

	public Banco() {
		// JDBC
		// String url = "jdbc:hsqldb:mem:mymemdb";
		// String url = "jdbc:hsqldb:file:./banco/myfile.db";

		String url = "jdbc:hsqldb:hsql://localhost/myserver";

		// String url = "jdbc:postgresql://localhost/database"
		// <!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
		// <dependency>
		// <groupId>org.postgresql</groupId>
		// <artifactId>postgresql</artifactId>
		// <version>42.2.23</version>
		// </dependency>

		String usuario = "SA";
		String senha = "";

		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			conexao = DriverManager.getConnection(url, usuario, senha);
			createDatabase();
			loadDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createDatabase() {
		Statement createTable;
		try {
			createTable = conexao.createStatement();
			createTable.execute(
					"CREATE TABLE LANCAMENTOS (TIPO VARCHAR(1), " + "DESCRICAO VARCHAR(500), VALOR VARCHAR(500) );");
			createTable.close();
		} catch (SQLException e) {
			System.out.println("Banco ja Existe: " + e.getMessage());

		}

		
	}

	public Statement createStatement() throws SQLException {
		return conexao.createStatement();
	}

	public PreparedStatement prepareStatement(String string) throws SQLException {
		return conexao.prepareStatement(string);
	}
	
	
	private void loadDatabase() {
		Statement insert;
		try {
			insert = conexao.createStatement();		
			insert.execute("INSERT INTO LANCAMENTOS (TIPO, DESCRICAO, VALOR) VALUES('D','DESPESA', '10.0' )  ");
			insert.execute("INSERT INTO LANCAMENTOS (TIPO, DESCRICAO, VALOR) VALUES('R','RECEITA', '100.0' )  ");
			insert.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
