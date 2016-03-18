package Geral;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection obtemConexao() throws SQLException {		
		return DriverManager.getConnection("jdbc:mysql://localhost/projeto_ppint?user=root&password=#9Mysql#10");
	}
}
