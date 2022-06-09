package main.java.de.car2go;

import main.java.de.car2go.controller.Controller;
import main.java.de.car2go.databasemanager.DatabaseManager;
import main.java.de.car2go.gui.GUIManager;

import java.sql.Connection;

public class Application {

    public static void main(String[] args) {

        DatabaseManager databaseManager = new DatabaseManager();
        Connection connection = databaseManager.getConnection();
        Controller controller = new Controller(connection);
        GUIManager gui = new GUIManager(controller);

       /*

        String insertIntoKunden = SqlStatementBuilder.createInsertStatement("Kunden",
                List.of("Personen_ID","Nachname","Vorname","Geburtsdatum","Email","Telefonnummer","Adresse","Mahnungen","Anzahl_Verträge"),
                List.of("Kunden_Seq.nextVal","'Jürgen'","'Meier'","TO_DATE('28.01.1998','dd.mm.yyyy')","'LOL@gmail.com'","12345678","'XDDDD'","0","0"));

        SqlStatementBuilder.performAction(insertIntoKunden,connection);

        String updateKunden = SqlStatementBuilder.createUpdateStatement("Kunden","SET Nachname = 'Hans'","");
        SqlStatementBuilder.performAction(updateKunden,connection);

        SqlProceduresAndFunctions.deleteCustomerData(2,connection);

        SqlProceduresAndFunctions.raiseWagesForRenter(1,10,connection);


        SqlProceduresAndFunctions.allVehiclesInTimeFrame("20.05.2002","20.06.2002",connection);

        String deleteKunden = SqlStatementBuilder.createDeleteStatement("Kunden","WHERE Personen_ID <= 3");
        SqlStatementBuilder.performAction(deleteKunden,connection);

        String selectAllFromKunden = SqlStatementBuilder.createSelectStatement("*","Kunden","WHERE Personen_ID > 0");
        ResultSet resultSet = SqlStatementBuilder.performAction(selectAllFromKunden,connection);
        try {
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1) + " "+ resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */


    }


}
