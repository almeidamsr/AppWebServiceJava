package mat.web.service;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConexaoMysql {
	
	private static final String URL = "jdbc:mysql://localhost/exemplo";
    private static final String USER = "root";
    private static final String SENHA = "matheus";
    
    public static Connection obtemConexao() throws SQLException{
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return (Connection) DriverManager.getConnection(URL, USER, SENHA);
    }
}