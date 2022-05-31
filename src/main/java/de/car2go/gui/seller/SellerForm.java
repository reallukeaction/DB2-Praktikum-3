package main.java.de.car2go.gui.seller;

import main.java.de.car2go.controller.Controller;

import javax.swing.*;

public class SellerForm {
    private JButton kundenHinzufügenButton;
    private JButton autoHinzufügemButton;
    private JButton mietvertragErstellenButton;
    private JPanel panel;

    public SellerForm(Controller controller){

    }
    public JPanel getPanel(){
        return panel;
    }
}
