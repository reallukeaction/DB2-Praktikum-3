package main.java.de.car2go.sqlbuilder;

import main.java.de.car2go.helper.Helper;

import java.sql.*;

public class SqlProceduresAndFunctions {


    public static void deleteCustomerData(int id, Connection connection){
        String procedure = "{call Delete_Kunden_Data(?)}";
        try {
            CallableStatement callableStatement = connection.prepareCall(procedure);
            callableStatement.setInt(1,id);
            callableStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Could not execute procedure.");
        }
    }

    public static void raiseWagesForRenter(int filialenId, int percentage, Connection connection){
        String procedure = "{call raise_wages(?,?)}";
        try {
            CallableStatement callableStatement = connection.prepareCall(procedure);
            callableStatement.setInt(1,filialenId);
            callableStatement.setInt(2,percentage);
            callableStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Could not execute procedure.");
        }
    }

    //TODO FIX
    public static String allVehiclesInTimeFrame(String startDate, String endDate, Connection connection){
        String function = "{call alleFahrzeugeImZeitraum(?,?)}";
        startDate = Helper.fromStringToDate(startDate);
        endDate = Helper.fromStringToDate(endDate);
        try {
            CallableStatement callableStatement = connection.prepareCall(function);
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.setString(2,startDate);
            callableStatement.setString(3,endDate);
            String temp = callableStatement.getString(1);
            return temp;
        } catch (SQLException e) {
            throw new RuntimeException("Could not execute function.");
        }
    }


}
