package main.java.de.car2go.helper;

import java.util.List;

public class Helper {

    public static String concatStringsFromList(List<String> strings, String concatenationSymbole) {
        String concatString = "";
        for (int i = 0; i < strings.size(); i++) {
            if (i == strings.size() - 1) {
                concatString += strings.get(i);
            } else {
                concatString += strings.get(i);
                concatString += concatenationSymbole + " ";
            }
        }
        return concatString;
    }

    public static String fromStringToDate(String date){
        //if(date.matches("\\d{2}.\\d{2}.\\d{4}") && date.contains(".")){
            String temp = "TO_DATE('"+date+"','dd.mm.yyyy')";
            return temp;
       // } else {
        //    throw new RuntimeException("Invalid date.");
        //}
    }
}
