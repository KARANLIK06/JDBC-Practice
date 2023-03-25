package jdbctests;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        String dbUrl="jdbc:oracle:thin:@34.227.92.52:1521:XE"; // dbProject --> HR--> Right click--> click Properties-->copy/paste URL
        String dbUsername="hr";
        String dbPassword="hr";

        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword); //Connection —> Helps our java project connect to database(Java projemizin veritabanına bağlanmasına yardımcı olur)
        Statement statement = connection.createStatement(); //Statement   —> Helps to write and execute SQL query(SQL sorgusu yazmaya ve yürütmeye yardımcı olur)
        ResultSet resultSet=statement.executeQuery("SELECT * FROM regions"); //ResultSet    —>  A datastructure where we can store the data that came from database(Veritabanından gelen verileri saklayabileceğimiz bir veri yapısı)

/*
        //next()---->  Move pointer to first row
        resultSet.next();

        // getting information with column Label
        System.out.println(resultSet.getString("region_name"));

        // getting information with column index(starts 1)
        System.out.println(resultSet.getString(2));

        // 1 - Europe
        // 2 - Americas
        System.out.println(resultSet.getInt(1)+" - "+resultSet.getString(2));

        //move to second row
        resultSet.next();
        System.out.println(resultSet.getInt(1)+" - "+resultSet.getString(2));

        //move to third row
        resultSet.next();
        System.out.println(resultSet.getInt(1)+" - "+resultSet.getString(2));

        //move to fourth row
        resultSet.next();
        System.out.println(resultSet.getInt(1)+" - "+resultSet.getString(2));

 */
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+" - "+resultSet.getString(2));
        }

        // close connection
        resultSet.close();
        statement.close();
        connection.close();
    }
}
