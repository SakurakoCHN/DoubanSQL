package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DAOBase implements DAO{
public Connection getConnection()
{
	Connection con=null;
	try {
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=mySQL;user=st;password=st";
	con=DriverManager.getConnection(url);
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return con;
}
	
}
