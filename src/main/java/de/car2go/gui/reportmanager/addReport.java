package main.java.de.car2go.gui.reportmanager;

import main.java.de.car2go.controller.Controller;
import main.java.de.car2go.gui.GUIAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class addReport {
    private JTextField textField_fahrzeug;
    private JTextField textField_vertrag;
    private JTextField textField_maengel;
    private JTextField textField_schaden;
    private JButton createNewReportButton;
    private JLabel Fahrzeug_ID;
    private JLabel Vertrag_ID;
    private JLabel Maengel;
    private JLabel Schaden;
    private JPanel panel;
    private JLabel kunden_id;
    private JTextField textField_kunden;
    private JButton deleteReportButton;
    private JButton updateReportButton;

    public addReport(Controller controller) {

        createNewReportButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField_fahrzeug.getText().equals("") || textField_vertrag.getText().equals("") ||
                textField_schaden.getText().equals("") || textField_kunden.getText().equals("")){
                    message("EINGABE NICHT VOLLSTÄNDIG!");
                    return;
                }
                if(!isDouble(textField_schaden.getText())){
                    message("Invalide Eingabe für Schaden! Bitte in der Form, xx.xx eingeben!");
                    return;
                }
                if(!isInt(textField_kunden.getText())){
                    message("Eingabe für Kunden ID ist keine ID!");
                    return;
                }
                if(!isInt(textField_fahrzeug.getText())){
                    message("Eingabe für Fahrzeug ID ist keine ID!");
                    return;
                }
                if(!isInt(textField_vertrag.getText())){
                    message("Eingabe für Vertrags_ID is keine ID!");
                }
                message("Eingabe erfolgreich");
                controller.addInput(GUIAction.INSERT_GUTACHTEN, List.of(textField_kunden.getText(),textField_fahrzeug.getText(),textField_vertrag.getText(),textField_maengel.getText(),textField_schaden.getText()));
                empty();
            }
        });
        deleteReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField_fahrzeug.getText().equals("") || textField_vertrag.getText().equals("") ||
                        textField_schaden.getText().equals("") || textField_kunden.getText().equals("")){
                    message("EINGABE NICHT VOLLSTÄNDIG!");
                    return;
                }
                if(!isDouble(textField_schaden.getText())){
                    message("Invalide Eingabe für Schaden! Bitte in der Form, xx.xx eingeben!");
                    return;
                }
                if(!isInt(textField_kunden.getText())){
                    message("Eingabe für Kunden ID ist keine ID!");
                    return;
                }
                if(!isInt(textField_fahrzeug.getText())){
                    message("Eingabe für Fahrzeug ID ist keine ID!");
                    return;
                }
                if(!isInt(textField_vertrag.getText())){
                    message("Eingabe für Vertrags_ID is keine ID!");
                }
                message("Eingabe erfolgreich");
                controller.addInput(GUIAction.DELETE_GUTACHTEN, List.of(textField_kunden.getText(),textField_fahrzeug.getText(),textField_vertrag.getText(),textField_maengel.getText(),textField_schaden.getText()));
            }
        });
        updateReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!isDouble(textField_schaden.getText())){
                    message("Invalide Eingabe für Schaden! Bitte in der Form, xx.xx eingeben!");
                    return;
                }
                if(textField_fahrzeug.getText().length() > 0 || textField_kunden.getText().length() > 0){
                    message("Fahrzeug und Kunde können nicht geändert werden, nur die Schadenssumme.");
                    return;
                }
                if(textField_schaden.getText().equals("") || textField_vertrag.getText().equals("")){
                    message("Invalide Eingabe. Bitte Schadenssumme und Vertrag angeben.");
                    return;
                }

                message("Eingabe erfolgreich");
                controller.addInput(GUIAction.UPDATE_GUTACHTEN, List.of(textField_kunden.getText(),textField_fahrzeug.getText(),textField_vertrag.getText(),textField_maengel.getText(),textField_schaden.getText()));
                empty();
            }
        });
    }

    private void empty(){
        textField_fahrzeug.setText("");
        textField_kunden.setText("");
        textField_maengel.setText("");
        textField_schaden.setText("");
        textField_vertrag.setText("");
    }

    private void message(String s){
        JOptionPane.showMessageDialog(null, s);
    }

    private boolean isDouble(String s){
        try{
            Double d = Double.parseDouble(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private boolean isInt(String s){
        try{
            int i = Integer.parseInt(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }

   public JPanel getPanel(){
        return panel;
   }
}
