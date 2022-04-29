import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbDemo {
	private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE" + "(ID serial,"
			+ " NAME varchar(100) NOT NULL," + " SALARY numeric(15, 2) NOT NULL,"
			+ " CREATED_DATE timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP," + " PRIMARY KEY (ID)" + ")";
	
	//public static void main(String[] args) 
	public static void main(String[] args){
		try {
			Connection connection = DriverManager.getConnection(
			        "jdbc:postgresql://127.0.0.1:5432/db1", "postgres", "Create123@");
			System.out.println(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
