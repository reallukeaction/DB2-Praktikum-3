package main.java.de.car2go.controller;

import main.java.de.car2go.gui.GUIAction;
import main.java.de.car2go.helper.Helper;
import main.java.de.car2go.sqlbuilder.SqlProceduresAndFunctions;
import main.java.de.car2go.sqlbuilder.SqlStatementBuilder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller {


    private Connection connection;
    public Controller(Connection connection){
        this.connection = connection;
    }


    public void addInput(GUIAction guiAction, List<String> inputs){
        switch (guiAction){
            case INSERT_GUTACHTEN: performInsertIntoGutachten(inputs); break;
            case DELETE_GUTACHTEN: performSearchAndDeleteOnGutachten(inputs); break;
            case UPDATE_GUTACHTEN: performSearchAndUpdateOnGutachten(inputs); break;
            case INSERT_KUNDEN: performInsertIntoKunden(inputs); break;
            case INSERT_FAHRZEUGE: performInsertIntoFahrzeuge(inputs); break;
            case INSERT_VERTRAEGE: performInsertIntoVertraege(inputs); break;
            case RAISE_WAGES_20: performRaiseWages20(inputs); break;
            case DELETE_KUNDEN: performDeleteOnKunden(inputs);break;
            case SELECT_VERMIETER: performSelectOnVermieter(inputs); break;
            default: break;
        }

    }


    private void performSearchAndDeleteOnGutachten(List<String> inputs){
        String selectSpecificGutachten = SqlStatementBuilder.createSelectStatement("Gutachten_ID", "Gutachten", "WHERE Verträge_ID = "+inputs.get(2));
        ResultSet resultSet = SqlStatementBuilder.performAction(selectSpecificGutachten,connection);
        try {
            while (resultSet.next()){
                String deleteSpecificGutachten = SqlStatementBuilder.createDeleteStatement("Gutachten","WHERE Gutachten_ID = "+ resultSet.getInt(1));
                SqlStatementBuilder.performAction(deleteSpecificGutachten,connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void performSearchAndUpdateOnGutachten(List<String> inputs){
        String selectSpecificGutachten = SqlStatementBuilder.createSelectStatement("Gutachten_ID", "Gutachten", "WHERE Verträge_ID = "+inputs.get(2));
        ResultSet resultSet = SqlStatementBuilder.performAction(selectSpecificGutachten,connection);
        try {
            while (resultSet.next()){
                String updateOnGutachten = SqlStatementBuilder.createUpdateStatement("Gutachten","SET Schadenssumme = " + inputs.get(4), "WHERE Gutachten_ID = "+ resultSet.getInt(1));
                SqlStatementBuilder.performAction(updateOnGutachten,connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void performInsertIntoGutachten(List<String> inputs){
        String insertIntoGutachten = SqlStatementBuilder.createInsertStatement("Gutachten",
                List.of("Personen_ID","Fahrzeuge_ID","Verträge_ID","Mengel","Schadenssumme"),
                List.of(inputs.get(0),inputs.get(1),inputs.get(2),"'"+inputs.get(3)+"'",inputs.get(4)));
        SqlStatementBuilder.performAction(insertIntoGutachten,connection);
    }

    private void performInsertIntoKunden(List<String> inputs){
        String insertIntoKunden = SqlStatementBuilder.createInsertStatement("Kunden",
                List.of("Personen_ID","Nachname","Vorname","Geburtsdatum","Email","Telefonnummer","Adresse","Mahnungen","Anzahl_Verträge"),
                List.of("Kunden_Seq.nextVal","'"+inputs.get(0)+"'","'"+inputs.get(1)+"'", Helper.fromStringToDate(inputs.get(2)),"'"+inputs.get(3)+"'",inputs.get(4),"'"+inputs.get(5)+"'","0","0"));
        SqlStatementBuilder.performAction(insertIntoKunden,connection);
    }

    private void performInsertIntoFahrzeuge(List<String> inputs){
        String insertIntoFahrzeuge = SqlStatementBuilder.createInsertStatement("Fahrzeuge",List.of("Typen_ID","Führerscheinklassen_ID","Beschreibung","Kilometerstand","Tankfüllung","Preis_Pro_Tag","Einkaufspreis"),
                List.of(inputs.get(0),inputs.get(1),"'"+inputs.get(2)+"'",inputs.get(3),inputs.get(4),inputs.get(5),inputs.get(6)));
        SqlStatementBuilder.performAction(insertIntoFahrzeuge,connection);
    }

    private void performInsertIntoVertraege(List<String> inputs){
        String insertIntoVerträge = SqlStatementBuilder.createInsertStatement("Verträge",List.of("Fahrzeuge_ID","Kunden_Personen_ID","Vermieter_Personen_ID","Beschreibung","Von","Bis","Zurückgebracht_Am"),
                List.of(inputs.get(0),inputs.get(1),inputs.get(2),"'"+inputs.get(3)+"'",Helper.fromStringToDate(inputs.get(4)),Helper.fromStringToDate(inputs.get(5)),Helper.fromStringToDate(inputs.get(6))));
        SqlStatementBuilder.performAction(insertIntoVerträge,connection);
    }

    private void performRaiseWages20(List<String> inputs){
        SqlProceduresAndFunctions.raiseWagesForRenter(Integer.parseInt(inputs.get(0)),20,connection);
    }

    private void performDeleteOnKunden(List<String> inputs){
        SqlProceduresAndFunctions.deleteCustomerData(Integer.parseInt(inputs.get(0)),connection);
    }

    public String performSelectOnVermieter(List<String> inputs){
        String selectOnVermieter = SqlStatementBuilder.createSelectStatement("Nachname,Vorname,Gehalt","Vermieter","WHERE Filialen_ID = "+ inputs.get(0));
        ResultSet resultSet = SqlStatementBuilder.performAction(selectOnVermieter,connection);
        String result = "";
            String entry = "";
            try {
                while (resultSet.next()){
                    entry+="Nachname: "+resultSet.getString(1)+" Vorname: "+resultSet.getString(2)+" Gehalt: "+resultSet.getInt(3);
                    result+=entry+"\n";
                    entry="";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
    }

    public String performSelectOnKunden(List<String> inputs){
        String selectOnKunden = SqlStatementBuilder.createSelectStatement("Nachname,Vorname,Personen_ID","Kunden","");
        ResultSet resultSet = SqlStatementBuilder.performAction(selectOnKunden,connection);
        String result = "";
        String entry = "";
        try {
            while (resultSet.next()){
                entry+="Nachname: "+resultSet.getString(1)+" Vorname: "+resultSet.getString(2)+" ID: "+resultSet.getInt(3);
                result+=entry+"\n";
                entry="";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
