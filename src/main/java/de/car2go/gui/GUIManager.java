package main.java.de.car2go.gui;

import main.java.de.car2go.controller.Controller;
import main.java.de.car2go.gui.procedureorfunction.DeleteCustomerData;
import main.java.de.car2go.gui.procedureorfunction.RaiseWagesforRenter;
import main.java.de.car2go.gui.reportmanager.addReport;
import main.java.de.car2go.gui.seller.addBuyer;
import main.java.de.car2go.gui.seller.addCar;
import main.java.de.car2go.gui.seller.addContract;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIManager {
    private JButton openReportForm = new JButton("Gutachten hinzufuegen");
    private JButton openBuyerForm = new JButton("Kunden hinzufuegen");
    private JButton openCarForm = new JButton("Auto hinzufuegen");
    private JButton openContractForm = new JButton("Vertrag hinzufuegen");
    private JButton delete_customer_data = new JButton("Kundendaten, löschen");
    private JButton raise_wages_renter = new JButton("Gehalt von Vermieter erhöhen");
    private JButton abort = new JButton("abort");
    private JFrame frame = new JFrame("Car2Go");
    private JPanel mainPanel = new JPanel();
    private JPanel reportForm ;
    private JPanel buyerForm ;
    private JPanel carForm ;
    private JPanel contractForm ;
    private JPanel customerData ;
    private JPanel raiseWages;



    public GUIManager(Controller controller) {
        addReport addReport = new addReport(controller);
        addBuyer addBuyer = new addBuyer(controller);
        addCar addCar = new addCar(controller);
        addContract addContract = new addContract(controller);
        RaiseWagesforRenter raiseWagesRenter = new RaiseWagesforRenter(controller);
        DeleteCustomerData deleteCData = new DeleteCustomerData(controller);

        this.reportForm = addReport.getPanel();
        this.buyerForm = addBuyer.getPanel();
        this.carForm = addCar.getPanel();
        this.contractForm = addContract.getPanel();
        this.customerData = deleteCData.getPanel();
        this.raiseWages = raiseWagesRenter.getPanel();

        mainPanel.add(openReportForm);
        mainPanel.add(openBuyerForm);
        mainPanel.add(openCarForm);
        mainPanel.add(openContractForm);
        mainPanel.add(delete_customer_data);
        mainPanel.add(raise_wages_renter);
        mainPanel.add(abort);
        frame.add(mainPanel);

        frame.setBounds(200,200, 1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        openReportForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.add(reportForm);
                frame.pack();
            }
        });

        openBuyerForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.add(buyerForm);
                frame.pack();
            }
        });
        openCarForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.add(carForm);
                frame.pack();
            }
        });
        openContractForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.add(contractForm);
                frame.pack();
            }
        });
        delete_customer_data.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.add(customerData);
                frame.pack();
            }
        });
        raise_wages_renter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.add(raiseWages);
                frame.pack();
            }
        });
        abort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(reportForm);
                frame.remove(carForm);
                frame.remove(contractForm);
                frame.remove(buyerForm);
                frame.remove(customerData);
                frame.remove(raiseWages);
                frame.pack();
                frame.repaint();
            }
        });

    }
}
