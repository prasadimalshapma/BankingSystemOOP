
package bankGUI;

import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainMenu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JDesktopPane desktopPane;
    private List<Account> accounts;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainMenu frame = new MainMenu();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainMenu() {
        setTitle("Bank Management System");
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

       
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to exit?", "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        
        accounts = AccountDataLoader.loadAccounts();

       
        try {
            Image backgroundImage = ImageIO.read(new File("download (1).jfif"));
            desktopPane = new JDesktopPane() {
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    if (backgroundImage != null) {
                        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                    }
                    g.setColor(Color.WHITE);
                    g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
            desktopPane = new JDesktopPane();
        }

        desktopPane.setLayout(null); 
        setContentPane(desktopPane);

       
        JLabel welcomeLabel = new JLabel("Welcome to Bank Management System", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setBounds(150, 50, 500, 40);
        desktopPane.add(welcomeLabel);

        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenuItem mntmCustomer = new JMenuItem("Customer");
        mnFile.add(mntmCustomer);
        mntmCustomer.addActionListener(e -> {
            Customerpanel cp = new Customerpanel();
            desktopPane.add(cp);
            cp.setVisible(true);
        });

        JMenuItem mntmAccount = new JMenuItem("Account");
        mnFile.add(mntmAccount);
        mntmAccount.addActionListener(e -> {
            Accountpanal ap = new Accountpanal();
            desktopPane.add(ap);
            ap.setVisible(true);
        });

        JMenu mnTransaction = new JMenu("Transaction");
        menuBar.add(mnTransaction);

        JMenuItem mntmDeposit = new JMenuItem("Deposit");
        mnTransaction.add(mntmDeposit);
        mntmDeposit.addActionListener(e -> {
            Depositpanal dp = new Depositpanal(accounts);
            desktopPane.add(dp);
            dp.setVisible(true);
        });

        JMenuItem mntmWithdraw = new JMenuItem("Withdraw");
        mnTransaction.add(mntmWithdraw);
        mntmWithdraw.addActionListener(e -> {
            Withdrawpanal wp = new Withdrawpanal(accounts);
            desktopPane.add(wp);
            wp.setVisible(true);
        });

        JMenu mnTransfer = new JMenu("Transfer");
        menuBar.add(mnTransfer);

        JMenuItem mntmAccountToAccount = new JMenuItem("Account to Account");
        mnTransfer.add(mntmAccountToAccount);
        mntmAccountToAccount.addActionListener(e -> {
            Accounttoaccount ata = new Accounttoaccount(accounts);
            desktopPane.add(ata);
            ata.setVisible(true);
        });


        JMenu mnBalance = new JMenu("Balance");
        menuBar.add(mnBalance);

        JMenuItem mntmViewBalance = new JMenuItem("View Balance");
        mnBalance.add(mntmViewBalance);
        mntmViewBalance.addActionListener(e -> {
            Balancepanal bp = new Balancepanal(accounts);
            desktopPane.add(bp);
            bp.setVisible(true);
        });

        
    }
}
