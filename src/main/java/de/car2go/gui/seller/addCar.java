package main.java.de.car2go.gui.seller;

import main.java.de.car2go.controller.Controller;
import main.java.de.car2go.gui.GUIAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class addCar {
    private JTextField textField_fahrzeugTyp;
    private JTextField textField_fueherescheinklasse;
    private JTextField textField_beschr;
    private JTextField textField_km;
    private JTextField textField_tank;
    private JTextField textField_pricePerDay;
    private JTextField textField_price;
    private JPanel panel;
    private JButton button;

    public addCar(Controller controller){

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addInput(GUIAction.INSERT_FAHRZEUGE, List.of(textField_fahrzeugTyp.getText(),textField_fueherescheinklasse.getText(),textField_beschr.getText(),textField_km.getText(),textField_tank.getText(),
                textField_pricePerDay.getText(),textField_price.getText()));
                empty();
            }
        });
    }
    private void empty(){
        textField_beschr.setText("");
        textField_fahrzeugTyp.setText("");
        textField_fueherescheinklasse.setText("");
        textField_km.setText("");
        textField_price.setText("");
        textField_pricePerDay.setText("");
        textField_tank.setText("");

    }



    public JPanel getPanel(){
        return panel;
    }
}
