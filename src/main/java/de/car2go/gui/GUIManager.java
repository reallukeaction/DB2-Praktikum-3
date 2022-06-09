package main.java.de.car2go.gui;

import main.java.de.car2go.controller.Controller;
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
    private JButton abort = new JButton("abort");
    private JFrame frame = new JFrame("Car2Go");
    private JPanel mainPanel = new JPanel();
    private JPanel reportForm ;
    private JPanel buyerForm ;
    private JPanel carForm ;
    private JPanel contractForm ;



    public GUIManager(Controller controller) {
        addReport addReport = new addReport(controller);
        addBuyer addBuyer = new addBuyer(controller);
        addCar addCar = new addCar(controller);
        addContract addContract = new addContract(controller);

        this.reportForm = addReport.getPanel();
        this.buyerForm = addBuyer.getPanel();
        this.carForm = addCar.getPanel();
        this.contractForm = addContract.getPanel();

        mainPanel.add(openReportForm);
        mainPanel.add(openBuyerForm);
        mainPanel.add(openCarForm);
        mainPanel.add(openContractForm);
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
        abort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(reportForm);
                frame.remove(carForm);
                frame.remove(contractForm);
                frame.remove(buyerForm);
                frame.pack();
                frame.repaint();
            }
        });

    }
}
