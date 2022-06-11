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
                area_result.setText("");
                controller.addInput(GUIAction.DELETE_KUNDEN, List.of(textField1.getText()));
                String result = controller.performSelectOnKunden(List.of(textField1.getText()));
                area_result.setText(result);
                empthy();
            }
        });

    }
    private void empthy(){
        textField1.setText("");
    }
    public JPanel getPanel(){
        return this.panel;
    }
}
