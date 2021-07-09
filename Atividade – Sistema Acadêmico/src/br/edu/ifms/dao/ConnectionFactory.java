package br.edu.ifms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() throws SQLException{
	
	String dbURL = "jdbc:mysql://localhost:3306/academicodb?useTimezone=True&serverTimezone=UTC";
	String username = "root";
	String password = "yeshua1206";
	
	Connection conn = null;
	
	conn = (Connection) DriverManager.getConnection(dbURL, username, password);
	
	if (conn != null) {
		System.out.println("CONECTADO!!\n");
	}else {
		System.out.println("ERRO NA CANEXÃO!!!");
	}
	
	return conn;
	}
}
