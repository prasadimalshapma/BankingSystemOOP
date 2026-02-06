package bankGUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.LineBorder;
import java.util.List;

public class Accountpanal extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private Image backgroundImage;

    public Accountpanal() {
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Account Panel");
        setBounds(100, 100, 450, 400);

      
        try {
            backgroundImage = ImageIO.read(new File("images (2).jfif"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        getRootPane().setBorder(new LineBorder(Color.WHITE, 3));

       
        JPanel mainPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setOpaque(false);
        getContentPane().add(mainPanel, BorderLayout.CENTER);

      
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(true);
        contentPanel.setBackground(new Color(0, 0, 0, 120));

        
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

       
        JLabel heading = new JLabel("Customer Accounts");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setForeground(Color.YELLOW);
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(heading);
        contentPanel.add(Box.createVerticalStrut(15));

       
        List<Account> accounts = AccountDataLoader.loadAccounts();

        for (Account acc : accounts) {
            JPanel card = new JPanel();
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
            card.setOpaque(false);
            card.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
            card.setMaximumSize(new Dimension(350, 50));

            JLabel label = new JLabel("Name: " + acc.getFirstName() + " " + acc.getLastName()
                    + " | Account #: " + acc.getAccountNum());
            label.setFont(new Font("Arial", Font.BOLD, 14));
            label.setForeground(Color.WHITE);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);

            card.add(Box.createVerticalStrut(5));
            card.add(label);
            card.add(Box.createVerticalStrut(5));

            contentPanel.add(card);
            contentPanel.add(Box.createVerticalStrut(10));
        }
    }
}
