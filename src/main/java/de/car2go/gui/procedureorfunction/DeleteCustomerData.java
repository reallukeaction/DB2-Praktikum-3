package main.java.de.car2go.gui.procedureorfunction;

import main.java.de.car2go.controller.Controller;
import main.java.de.car2go.gui.GUIAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

public class DeleteCustomerData {
    private JLabel customer_id;
    private JTextArea area_result;
    private JButton button_detelte;
    private JPanel panel;
    private JTextField textField1;

    public DeleteCustomerData(Controller controller) {
        button_detelte.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addInput(GUIAction.DELETE_KUNDEN, List.of(textField1.getText()));
            }
        });

    }
    public JPanel getPanel(){
        return this.panel;
    }
}
