package bankGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class Balancepanal extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;

    public Balancepanal(List<Account> accounts) {
        super("Balance Panel", true, true, true, true);
        setSize(500, 300);
        setLocation(20, 20);

        String[] columnNames = {"Account Number", "Customer Name", "Balance"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Account acc : accounts) {
            Object[] row = {
                acc.getAccountNum(),
                acc.getCustomerName(),
                acc.getBalance()
            };
            model.addRow(row);
        }

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
}
