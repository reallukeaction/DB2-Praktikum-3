package main.java.de.car2go.gui.procedureorfunction;

import main.java.de.car2go.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

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
                //TODO add database integration, write result into area_result

            }
        });

    }
    public JPanel getPanel(){
        return this.panel;
    }
}