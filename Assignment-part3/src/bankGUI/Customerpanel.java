package bankGUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.LineBorder;
import java.util.List;

public class Customerpanel extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private Image sideImage;
    private JTextArea customerArea;

    public Customerpanel() {
        setTitle("Customer");
        setClosable(true);
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setBounds(50, 50, 700, 400);

       
        try {
            sideImage = ImageIO.read(new File("images (7).jfif")); 
        } catch (IOException e) {
            e.printStackTrace();
        }

        getRootPane().setBorder(new LineBorder(Color.WHITE, 3));

        JPanel panel = new JPanel(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);

       
        JTextField txtCustomer = new JTextField("Customer Details");
        txtCustomer.setFont(new Font("Arial Black", Font.BOLD, 20));
        txtCustomer.setHorizontalAlignment(SwingConstants.CENTER);
        txtCustomer.setEditable(false);
        panel.add(txtCustomer, BorderLayout.NORTH);

       
        JLabel imageLabel = new JLabel();
        if (sideImage != null) {
            Image scaledImage = sideImage.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaledImage));
        }
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(imageLabel, BorderLayout.WEST);

        
        customerArea = new JTextArea();
        customerArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        customerArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(customerArea);
        panel.add(scrollPane, BorderLayout.CENTER);

       
        showCustomers();
    }

    private void showCustomers() {
        List<Customer> customers = CustomerDataLoader.loadCustomers(); 
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-20s %-20s\n", "First Name", "Last Name"));
        sb.append("========================================\n");
        for (Customer c : customers) {
            sb.append(String.format("%-20s %-20s\n", c.getFirstName(), c.getLastName()));
        }
        customerArea.setText(sb.toString());
    }
}
