package FoodOrdering;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FoodOrderGUI extends JFrame {
    private JPanel panel1;

    //CHECKBOXES
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    List<JCheckBox> cFoods;

    //RADIO BUTTONS
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    List<JRadioButton> rbDiscount;

    //BUTTON
    private JButton btnOrder;

    //APP CONSTRUCTOR
    public FoodOrderGUI() {
        cFoods = new ArrayList<>();
        cFoods.add(cPizza);
        cFoods.add(cBurger);
        cFoods.add(cFries);
        cFoods.add(cSoftDrinks);
        cFoods.add(cTea);
        cFoods.add(cSundae);

        rbDiscount = new ArrayList<>();
        rbDiscount.add(rbNone);
        rbDiscount.add(rb5);
        rbDiscount.add(rb10);
        rbDiscount.add(rb15);

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compute();
            }
        });
    }

    public static void main(String[] args) {
        FoodOrderGUI app = new FoodOrderGUI();
        app.setTitle("Food Ordering System");
        app.setContentPane(app.panel1);
        app.setSize(600, 500);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public void compute() {
        try {
            double total = 0;
            double discount = 0;

            String prompt = "";
            boolean foodIsSelected = false;
            boolean discountIsSelected = false;
            boolean withDiscount = false;

            for (JCheckBox c : cFoods) {
                if (c.isSelected()) {
                    foodIsSelected = true;
                    switch (c.getText()) {
                        case "Pizza":
                            total += 100;
                            break;
                        case "Burger":
                            total += 80;
                            break;
                        case "Fries":
                            total += 65;
                            break;
                        case "Soft Drinks":
                            total += 55;
                            break;
                        case "Tea":
                            total += 50;
                            break;
                        case "Sundae":
                            total += 40;
                            break;
                    }
                }
            }
            if (!foodIsSelected) {
                prompt +=  "You have not selected a food from the menu.\n";
            }

            for (JRadioButton rb : rbDiscount) {
                if (rb.isSelected()) {
                    discountIsSelected = true;
                    switch (rb.getText()) {
                        case "None":
                            //do nothing
                            break;
                        case "5% Off":
                            discount = total * 0.05;
                            withDiscount = true;
                            break;
                        case "10% Off":
                            discount = total * 0.10;
                            withDiscount = true;
                            break;
                        case "15% Off":
                            discount = total * 0.15;
                            withDiscount = true;
                            break;
                    }
                    break;
                }
            }
            if (!discountIsSelected) {
                prompt += "You have not selected a discount option.";
            }

            if (withDiscount) {
                total -= discount;
            }

            if (!foodIsSelected || !discountIsSelected) {
                throw new Exception(prompt);
            } else {
                JOptionPane.showMessageDialog(panel1, String.format("The total price is Php %.2f", total));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panel1, e.getMessage());
        }
    }
}
