import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BankApplication extends JFrame{
    private double balance = 0;
    private double previousTransaction = 0;
    private JLabel balanceLabel;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton prevTransactionButton;
    private JButton exitButton;
    public BankApplication(){
        setTitle("Banking Application");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6,1));

        balanceLabel = new JLabel("Balance: $" + balance);
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        prevTransactionButton = new JButton("Previous Transaction");
        exitButton = new JButton("Exit");

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String depositAmount = JOptionPane.showInputDialog("Enter amount to deposit:");
                if(depositAmount != null){
                    double amount = Double.parseDouble(depositAmount);
                    deposit(amount);
                }
            }
        });
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String withdrawAmount = JOptionPane.showInputDialog("Enter amount to withdraw");
                if(withdrawAmount != null){
                    double amount = Double.parseDouble(withdrawAmount);
                    withdraw(amount);
                }
            }
        });

        prevTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPreviousTransaction();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(balanceLabel);
        add(depositButton);
        add(withdrawButton);
        add(prevTransactionButton);
        add(exitButton);
    }

    private void deposit(double amount){
        if(amount>0){
            balance += amount;
            previousTransaction = amount;
            balanceLabel.setText("Balance: $" + balance);
            JOptionPane.showMessageDialog(null,"Deposit successful.new balance: $"+balance);
        }
        else {
            JOptionPane.showMessageDialog(null,"Invalid deposit amount ");
        }
    }
    private void withdraw(double amount){
        if(amount>0 && amount <= balance){
            balance -= amount;
            previousTransaction =- amount;
            balanceLabel.setText("Balance: $" +balance);
            JOptionPane.showMessageDialog(null,"Withdrawal successful. new balance : $" + balance);
        }
        else {
            JOptionPane.showMessageDialog(null,"Invalid Withdrawal amount. ");

        }
    }
    private void showPreviousTransaction(){
        if(previousTransaction>0){
            JOptionPane.showMessageDialog(null,"Deposited: $" + previousTransaction);
        }else if(previousTransaction<0){
            JOptionPane.showMessageDialog(null,"Withdrawn $" + (-previousTransaction));
        }else {
            JOptionPane.showMessageDialog(null,"No previous transaction");

        }
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->new BankApplication().setVisible(true));
    }
}
