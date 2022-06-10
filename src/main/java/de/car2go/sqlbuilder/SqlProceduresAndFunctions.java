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

}
