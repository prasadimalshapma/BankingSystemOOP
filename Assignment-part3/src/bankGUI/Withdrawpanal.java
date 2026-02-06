package bankGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Withdrawpanal extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtAccNumber;
    private JTextField txtAmount;
    private JTextArea resultArea;
    private List<Account> accounts;

    public Withdrawpanal(List<Account> accounts) {
        this.accounts = accounts;

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Withdraw Panel");
        setBounds(150, 150, 500, 350);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        getContentPane().add(panel, BorderLayout.NORTH);

        panel.add(new JLabel("Enter Account Number:"));
        txtAccNumber = new JTextField();
        panel.add(txtAccNumber);

        panel.add(new JLabel("Enter Withdraw Amount:"));
        txtAmount = new JTextField();
        panel.add(txtAmount);

        JButton btnWithdraw = new JButton("Withdraw");
        panel.add(btnWithdraw);

        resultArea = new JTextArea(6, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        btnWithdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleWithdraw();
            }
        });
    }

    private void handleWithdraw() {
        String accNumStr = txtAccNumber.getText().trim();
        String amountStr = txtAmount.getText().trim();

        if (accNumStr.isEmpty() || amountStr.isEmpty()) {
            resultArea.setText("Please enter both account number and amount.");
            return;
        }

        try {
            int accNum = Integer.parseInt(accNumStr);
            int amount = Integer.parseInt(amountStr);

            boolean found = false;

            for (Account acc : accounts) {
                if (acc.getAccountNum() == accNum) {
                    if (amount > acc.getBalance()) {
                        resultArea.setText("Insufficient balance for withdrawal.");
                    } else {
                        acc.withdraw(amount);
                        resultArea.setText("Withdrawal successful!\n\n" + acc.getAccountDetails());
                    }
                    found = true;
                    break;
                }
            }

            if (!found) {
                resultArea.setText("Account number not found.");
            }

        } catch (NumberFormatException e) {
            resultArea.setText("Please enter valid numeric values.");
        }
    }
}
