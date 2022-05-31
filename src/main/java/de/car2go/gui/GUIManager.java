package main.java.de.car2go.gui;

import main.java.de.car2go.controller.Controller;
import main.java.de.car2go.gui.reportmanager.ReportForm;
import main.java.de.car2go.gui.seller.SellerForm;
import main.java.de.car2go.gui.seller.addBuyer;
import main.java.de.car2go.gui.seller.addCar;
import main.java.de.car2go.gui.seller.addContract;

import javax.swing.*;

public class GUIManager {

    public GUIManager(Controller controller) {
        JFrame frame = new JFrame("DEBUG FORM");
        //frame.setContentPane(new ReportForm(controller).getPanel());
        //frame.setContentPane(new addBuyer(controller).getPanel());
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

        JPanel reportFormPanel = new ReportForm(controller).getPanel();
        JPanel addBuyerPanel = new addBuyer(controller).getPanel();
        JPanel addCarPanel = new addCar(controller).getPanel();
        JPanel addContractPanel = new addContract(controller).getPanel();
        JPanel sellerForm = new SellerForm(controller).getPanel();

        container.add(reportFormPanel);
        container.add(addBuyerPanel);
        container.add(addCarPanel);
        container.add(addContractPanel);
        container.add(sellerForm);
        frame.add(container);

        //panel1.set[Preferred/Maximum/Minimum]Size()
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
