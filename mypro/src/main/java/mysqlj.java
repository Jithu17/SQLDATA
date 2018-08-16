import java.sql.*;

public class mysqlj {
    public static void main(String[] agrs) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String dbUrl = "jdbc:mysql://127.0.0.1:13306/testdb";
        String user = "testuser";
        String pass = "password";

        try{
            myConn = DriverManager.getConnection(dbUrl, user, pass);
            System.out.println("Database connection successful! \n");

            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from customers");

            while (myRs.next()) {
                System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
            }

        }
        catch (Exception e){
            System.out.println("database fail connection");

        }
        finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }
}
