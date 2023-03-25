package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class Jdbc_examples {


    String dbUrl="jdbc:oracle:thin:@34.227.92.52:1521:XE"; // dbProject --> HR--> Right click--> click Properties-->copy/paste URL
    String dbUsername="hr";
    String dbPassword="hr";

    @Test
    public void test1() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery("SELECT * FROM departments");
/*
        // move to first row
        resultSet.next();

        System.out.println(resultSet.getString(2));
        // display departments table in 10 - Administration 200 - 1700 format


 */
        // code for iterating for each row
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+" - "+resultSet.getString(2)+" - "+resultSet.getString(3)+" - "+resultSet.getInt(4));
        }

        System.out.println("===========================================================================");

        resultSet=statement.executeQuery("SELECT * FROM regions");
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+" - "+resultSet.getString(2));
        }

        // close connection
        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void test2() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");

        // how to find how many rows we have for the query
        // move to last row
        resultSet.last();

        //get the row count
        int rowCount = resultSet.getRow();
        System.out.println(rowCount);

        // to move before first row after we use last method
        resultSet.beforeFirst();

        // print all second column information
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }

        // close connection
        resultSet.close();
        statement.close();
        connection.close();
    }
        @Test
        public void test3() throws SQLException {

            Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");



            // close connection
            resultSet.close();
            statement.close();
            connection.close();
    }
}
