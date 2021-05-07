package br.edu.ifms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		String dbURL = "jdbc:mysql://localhost:3306/academicodb?useTimezone=True&serverTimezone=UTC";
		String username = "root";
		String password = "yeshua1206";
		
		Connection conn = null;
		
		conn = (Connection) DriverManager.getConnection(dbURL, username, password);
		
		if (conn != null) {
			System.out.println("CONECTADO!!");
		}else {
			System.out.println("CONEXÃO FALHOU!!");
		}
		
		conn.close();
	}

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
	
	}
