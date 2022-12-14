package LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LeapYearGUI extends JFrame {
    private JPanel panel1;
    private JTextField tfYear;
    private JButton btnCheckYear;

    public LeapYearGUI() {
        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkYear();
            }
        });

        tfYear.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    checkYear();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        //LeapYear main function
        LeapYearGUI app = new LeapYearGUI();
        app.setTitle("Leap Year Checker");
        app.setContentPane(app.panel1);
        app.setSize(300, 400);
        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    public void checkYear() {
        try {
            int year = Integer.parseInt(tfYear.getText());
            if (((year % 4 == 0) && (year % 100 != 0)) || (year%400 == 0)) {
                JOptionPane.showMessageDialog(panel1, "Leap year");
            } else {
                JOptionPane.showMessageDialog(panel1, "Not a leap year");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panel1, e.toString());
        }
    }
}
