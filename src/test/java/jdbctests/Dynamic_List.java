package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dynamic_List {

    String dbUrl="jdbc:oracle:thin:@34.227.92.52:1521:XE";
    String dbUsername="hr";
    String dbPassword="hr";


    @Test
    public void test2() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select FIRST_NAME,LAST_NAME,SALARY,JOB_ID\n" +
                "from EMPLOYEES\n" +
                "where ROWNUM<6");

        // in order to get column names we need ResultSetMetaData
        ResultSetMetaData rsmd = resultSet.getMetaData();




        // close connection
        resultSet.close();
        statement.close();
        connection.close();
    }
}
