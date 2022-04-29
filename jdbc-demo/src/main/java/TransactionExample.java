import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TransactionExample {

	private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
	
	private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";
	
	private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE" + "(" + " ID serial,"
			+ " NAME varchar(100) NOT NULL," + " SALARY numeric(15, 2) NOT NULL,"
			+ " CREATED_DATE timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP," + " PRIMARY KEY (ID)" + ")";
	
	private static final String SQL_TABLE_DROP = "DROP TABLE EMPLOYEE";
	public static void main(String[] args) {
        try  {
        	Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/db1", "postgres", "Create123@");
                 Statement statement = connection.createStatement();
                 PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
                 PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);

            // start transaction block
            connection.setAutoCommit(false); // default true

            // Run list of insert commands
            psInsert.setString(1, "Harshith");
            psInsert.setBigDecimal(2, new BigDecimal(200000));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(1, "kungfu");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            // Run list of update commands

            // error, test rollback
            // org.postgresql.util.PSQLException: No value specified for parameter 1.
//            psUpdate.setBigDecimal(2, new BigDecimal(999.99));
//            psUpdate.setBigDecimal(1, new BigDecimal(999.99));
//            psUpdate.setString(2, "mkyong");
//            psUpdate.execute();

            // end transaction block, commit changes
            connection.commit();
            // good practice to set it back to default true
            connection.setAutoCommit(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}