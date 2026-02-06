package bankGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.border.LineBorder;

public class Accounttoaccount extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private Image backgroundImage;
    private JTextField txtFromAcc;
    private JTextField txtToAcc;
    private JTextField txtAmount;
    private JTextArea resultArea;

    private List<Account> accounts; 

    public Accounttoaccount(List<Account> accounts) {
        this.accounts = accounts; 

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Account to Account Transfer");
        setBounds(150, 150, 550, 400);

        try {
            backgroundImage = ImageIO.read(new File("images (8).jfif"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        getRootPane().setBorder(new LineBorder(Color.WHITE, 3));

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        panel.setLayout(new GridLayout(6, 2, 10, 10));
        panel.setOpaque(false);
        getContentPane().add(panel, BorderLayout.NORTH);

        panel.add(new JLabel("From Account Number:"));
        txtFromAcc = new JTextField();
        panel.add(txtFromAcc);

        panel.add(new JLabel("To Account Number:"));
        txtToAcc = new JTextField();
        panel.add(txtToAcc);

        panel.add(new JLabel("Amount to Transfer:"));
        txtAmount = new JTextField();
        panel.add(txtAmount);

        JButton btnTransfer = new JButton("Transfer");
        panel.add(btnTransfer);

        resultArea = new JTextArea(6, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        btnTransfer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleTransfer();
            }
        });
    }

    private void handleTransfer() {
        String fromStr = txtFromAcc.getText().trim();
        String toStr = txtToAcc.getText().trim();
        String amountStr = txtAmount.getText().trim();

        if (fromStr.isEmpty() || toStr.isEmpty() || amountStr.isEmpty()) {
            resultArea.setText("Please enter all fields.");
            return;
        }

        try {
            int fromAcc = Integer.parseInt(fromStr);
            int toAcc = Integer.parseInt(toStr);
            int amount = Integer.parseInt(amountStr);

            if (amount <= 0) {
                resultArea.setText("Amount must be greater than zero.");
                return;
            }

            Account sender = null, receiver = null;

            for (Account acc : accounts) {
                if (acc.getAccountNum() == fromAcc) {
                    sender = acc;
                }
                if (acc.getAccountNum() == toAcc) {
                    receiver = acc;
                }
            }

            if (sender == null || receiver == null) {
                resultArea.setText("One or both account numbers are invalid.");
                return;
            }

            if (sender.getBalance() < amount) {
                resultArea.setText("Insufficient funds in sender's account.");
                return;
            }

            sender.withdraw(amount);
            receiver.deposit(amount);

            String msg = "------------\n";
            msg += "Withdraw from: " + sender.getAccountNum() + " - " + sender.getFirstName() + " " + sender.getLastName() + "\n";
            msg += "Deposit to  : " + receiver.getAccountNum() + " - " + receiver.getFirstName() + " " + receiver.getLastName() + "\n";
            msg += "Amount      : Rs. " + amount + "\n";
            msg += "------------\n";
            msg += "Transfer Successful!";

            resultArea.setText(msg);

        } catch (NumberFormatException e) {
            resultArea.setText("Please enter valid numbers.");
        }
    }
}
