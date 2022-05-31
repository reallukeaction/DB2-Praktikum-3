package main.java.de.car2go.sqlbuilder;

import main.java.de.car2go.helper.Helper;

import java.sql.*;
import java.util.List;

public class SqlStatementBuilder {

    private static final String selectString = "SELECT %ATTRIBUTES% FROM %TABLE%";

    public static String createSelectStatement(String attributes, String table, String searchCondition) {
        String replacedSelectString = selectString;
        replacedSelectString = replacedSelectString.replaceAll("%ATTRIBUTES%", attributes);
        replacedSelectString = replacedSelectString.replaceAll("%TABLE%", table);
        replacedSelectString += " " + searchCondition;
        return replacedSelectString;
    }

    private static final String insertString = "INSERT INTO %TABLE% %ATTRIBUTES% VALUES (%VALUES%)";

    public static String createInsertStatement(String table, List<String> attributes, List<String> values) {
        if (attributes.size() > 0 && (attributes.size() != values.size())) {
            throw new IllegalArgumentException("The number of attributes and values must be the same!");
        }
        String replacedInsertString = insertString;
        replacedInsertString = replacedInsertString.replaceAll("%TABLE%", table);
        if (attributes.size() != 0) {
            replacedInsertString = replacedInsertString.replaceAll("%ATTRIBUTES%", "(" + Helper.concatStringsFromList(attributes, ",") + ")");
        } else {
            replacedInsertString = replacedInsertString.replaceAll("%ATTRIBUTES%", "");
        }

        replacedInsertString = replacedInsertString.replaceAll("%VALUES%", Helper.concatStringsFromList(values, ","));
        return replacedInsertString;
    }

    private static final String updateString = "UPDATE %TABLE% %UPDATE_CONDITION%";

    public static String createUpdateStatement(String table, String updateCondition, String searchCondition) {
        String replacedUpdateString = updateString;
        replacedUpdateString = replacedUpdateString.replaceAll("%TABLE%", table);
        replacedUpdateString = replacedUpdateString.replaceAll("%UPDATE_CONDITION%", updateCondition);
        replacedUpdateString += " " + searchCondition;
        return replacedUpdateString;
    }

    private static final String deleteString = "DELETE FROM %TABLE%";

    public static String createDeleteStatement(String table, String searchCondition) {
        String replacedDeleteString = deleteString;
        replacedDeleteString = replacedDeleteString.replaceAll("%TABLE%", table);
        replacedDeleteString += " " + searchCondition;
        return replacedDeleteString;
    }


    public static ResultSet performAction(String sqlString, Connection connection) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            if (sqlString.contains("INSERT") || sqlString.contains("UPDATE") || sqlString.contains("DELETE")) {
                statement.executeUpdate(sqlString);
            }
            if(sqlString.contains("SELECT")){
                resultSet = statement.executeQuery(sqlString);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(statement == null){
            throw new RuntimeException("Could not execute this statement.");
        }
        try {
            if(resultSet == null && connection.getAutoCommit() == false) {
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }


}
