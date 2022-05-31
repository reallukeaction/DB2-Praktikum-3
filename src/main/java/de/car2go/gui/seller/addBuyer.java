package main.java.de.car2go.gui.seller;

import main.java.de.car2go.controller.Controller;
import main.java.de.car2go.gui.GUIAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class addBuyer {
    private JTextField textField_name;
    private JLabel Vorname;
    private JTextField textField_nachname;
    private JTextField textField_birthday;
    private JTextField textField_email;
    private JTextField textField_phonenumber;
    private JLabel Adresse;
    private JTextField textField_adress;
    private JButton enterButton;
    private JPanel panel;

    public addBuyer(Controller controller){

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               controller.addInput(GUIAction.INSERT_KUNDEN, List.of(textField_name.getText(),textField_nachname.getText(),textField_birthday.getText(),textField_email.getText(),textField_phonenumber.getText(),textField_adress.getText()));
            }
        });
    }

    public JPanel getPanel(){
        return panel;
    }
}
