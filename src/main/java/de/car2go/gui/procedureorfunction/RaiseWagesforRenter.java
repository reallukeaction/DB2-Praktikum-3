package main.java.de.car2go.gui.procedureorfunction;

import main.java.de.car2go.controller.Controller;
import main.java.de.car2go.gui.GUIAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RaiseWagesforRenter {
    private JPanel panel;
    private JButton button_enter;
    private JLabel lable_shop_id;
    private JTextField textField_shop_id;
    private JTextArea textArea_result;

    public RaiseWagesforRenter(Controller controller){
        textArea_result.setEditable(false);
        button_enter.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea_result.setText("");
                controller.addInput(GUIAction.RAISE_WAGES_20, List.of(textField_shop_id.getText()));
                String result = controller.performSelectOnVermieter(List.of(textField_shop_id.getText()));
                textArea_result.setText(result);
                empthy();
            }

        });

    }
    private void empthy(){
        textField_shop_id.setText("");
    }
    public JPanel getPanel(){
        return panel;
    }

}
