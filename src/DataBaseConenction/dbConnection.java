package DataBaseConenction;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by wojtek on 28.01.2019.
 */
public class dbConnection {


    private static final String SQLiteCon = "jdbc:sqlite:schoolManagment.db";


    public static Connection getConection() throws SQLException {

        try {

            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SQLiteCon);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }







}