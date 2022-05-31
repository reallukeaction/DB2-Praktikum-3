package main.java.de.car2go.gui.seller;

import main.java.de.car2go.controller.Controller;
import main.java.de.car2go.gui.GUIAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class addContract {
    private JTextField textField_vehicle;
    private JTextField textField_buyer;
    private JTextField textField_seller;
    private JTextField textField_description;
    private JTextField textField_von;
    private JTextField textField_bis;
    private JButton button;
    private JPanel panel;
    private JTextField textField_back;

    public addContract(Controller controller){

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addInput(GUIAction.INSERT_VERTRAEGE, List.of(textField_vehicle.getText(),textField_buyer.getText(),textField_seller.getText(),textField_description.getText(),textField_von.getText(),textField_bis.getText(),textField_back.getText()));
            }
        });
    }
    public JPanel getPanel(){
        return panel;
    }

}
