package jdbctests;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        String dbUrl="jdbc:oracle:thin:@34.227.92.52:1521:XE";
        String dbUsername="hr";
        String dbPassword="hr";

        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery("SELECT * FROM employees");


        // close connection
        resultSet.close();
        statement.close();
        connection.close();
    }
}
