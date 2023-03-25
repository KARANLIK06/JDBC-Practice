package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfMapExample {
    String dbUrl="jdbc:oracle:thin:@34.227.92.52:1521:XE";
    String dbUsername="hr";
    String dbPassword="hr";

    @Test
    public void test1()  {
        // creating list for keeping all the rows maps
        List<Map<String,Object>> queryData = new ArrayList<>();

        Map<String,Object> row1= new HashMap<>();

        row1.put("FIRST_NAME","Steven");
        row1.put("LAST_NAME","King");
        row1.put("SALARY",24000);
        row1.put("JOB_ID","AD_PRES");

        System.out.println(row1.toString());

        Map<String,Object> row2= new HashMap<>();

        row2.put("FIRST_NAME","Neena");
        row2.put("LAST_NAME","Kochhar");
        row2.put("SALARY",17000);
        row2.put("JOB_ID","AD_VP");

        System.out.println(row2.toString());

        // adding rows one by one my list
        queryData.add(row1);
        queryData.add(row2);
        System.out.println(queryData);

        // get the Steven lastname directly from the list
        System.out.println(queryData.get(0).get("LAST_NAME"));

    }

    @Test
    public void test2() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select FIRST_NAME,LAST_NAME,SALARY,JOB_ID\n" +
                "from EMPLOYEES\n" +
                "where ROWNUM<6");

        // in order to get column names we need ResultSetMetaData
        ResultSetMetaData rsmd = resultSet.getMetaData();

        // move to first row
        resultSet.next();

        // creating list for keeping all the rows maps
        List<Map<String,Object>> queryData = new ArrayList<>();

        Map<String,Object> row1= new HashMap<>();

        row1.put(rsmd.getColumnName(1), resultSet.getString(1));
        row1.put(rsmd.getColumnName(2), resultSet.getString(2));
        row1.put(rsmd.getColumnName(3), resultSet.getString(3));
        row1.put(rsmd.getColumnName(4), resultSet.getString(4));


        System.out.println(row1.toString());


        // move to second row
        resultSet.next();

        Map<String,Object> row2= new HashMap<>();

        row2.put(rsmd.getColumnName(1), resultSet.getString(1));
        row2.put(rsmd.getColumnName(2), resultSet.getString(2));
        row2.put(rsmd.getColumnName(3), resultSet.getString(3));
        row2.put(rsmd.getColumnName(4), resultSet.getString(4));

        System.out.println(row2.toString());

        // adding rows one by one my list
        queryData.add(row1);
        queryData.add(row2);



        // close connection
        resultSet.close();
        statement.close();
        connection.close();
    }
}
