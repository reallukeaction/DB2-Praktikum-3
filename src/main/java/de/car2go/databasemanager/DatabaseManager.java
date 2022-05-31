package main.java.de.car2go.databasemanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private final String databaseUrl = "jdbc:oracle:thin:@studidb.gm.th-koeln.de:1521:vlesung";
    private final String databaseUsername = "inf2525";
    private final String databasePassword = "Peter";

    private Connection connection;

    public DatabaseManager(){
       if(init()){
           try {
               connection = DriverManager.getConnection(databaseUrl,databaseUsername, databasePassword);
           } catch (SQLException e) {
               System.out.println("Failed to connect to the database, check credentials.");
               e.printStackTrace();
           }
       } else {
           System.out.println("Failed to load driver.");
       }
    }

    private boolean init(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }


    public Connection getConnection() {
        return connection;
    }


}
