import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class for the main homepage of the application
class Homepage  implements ActionListener {
    JFrame frame =new JFrame();
    ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\bank_1f3e6.png");
    Image image= icon.getImage();
    JLabel label1=new JLabel("Welcome to 'GBI'...!!");
    JLabel label2=new JLabel("<html><b>GBI Bank</b> - Guiding Your<br>Financial Journey with Trust and Innovation</html>");
    JLabel label3=new JLabel();
    JButton checkBalance=new JButton("Check Bank Main.Balance");
    JButton withdraw=new JButton("Withdraw");
    JButton deposit=new JButton("Deposit");

    // Constructor sets up the UI components for the homepage
    Homepage(){
        label1.setBounds(5,10,360,30);
        label1.setFont(new Font("Arial", Font.BOLD, 35));
        label1.setForeground(new Color(161, 0, 255));

        label2.setBounds(0,80,360,100);
        label2.setFont(new Font("Arial",Font.BOLD,20));

        label3.setText("📞: +91 8345842707      📧: gbi.bank@gmail.com");
        label3.setBounds(40,600,360,20);

        checkBalance.setBounds(20,300,300,100);
        checkBalance.setFocusable(false);
        checkBalance.setFont(new Font("Arial", Font.BOLD, 25));
        checkBalance.setBackground(new Color(221, 0, 255));
        checkBalance.setForeground(Color.white);
        checkBalance.addActionListener(this);

        withdraw.setBounds(10,450,130,70);
        withdraw.setFocusable(false);
        withdraw.setFont(new Font("Arial", Font.BOLD, 20));
        withdraw.setBackground(new Color(200, 255, 0));
        withdraw.addActionListener(this);

        deposit.setBounds(190,450,130,70);
        deposit.setFocusable(false);
        deposit.setFont(new Font("Arial", Font.BOLD, 20));
        deposit.setBackground(new Color(255, 115, 0));
        deposit.addActionListener(this);

        frame.setSize(360,708);
        frame.setTitle("GBI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setIconImage(image);
        frame.getContentPane().setBackground(new Color(16, 224, 149));

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(checkBalance);
        frame.add(withdraw);
        frame.add(deposit);
    }
    // Action performed method to handle button clicks on the homepage
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==checkBalance){
            frame.dispose();
            new CheckBankBalance();
        } else if (e.getSource()==deposit) {
            frame.dispose();
            new Deposit();

        }
        else {
            frame.dispose();
            new Withdraw();
        }
    }
}

// Class to check bank balance
class CheckBankBalance implements ActionListener {
    JFrame frame = new JFrame();
    ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\bank_1f3e6.png");
    Image image = icon.getImage();
    JTextField textField = new JTextField();
    JLabel label1 = new JLabel("Your Account No.");
    JLabel label2 = new JLabel("Enter your MPIN(4-digit)");
    JPasswordField mpin = new JPasswordField();
    JButton button = new JButton("Submit");
    // Constructor sets up the UI components for the check balance screen
    CheckBankBalance() {
        textField.setBounds(20, 200, 300, 40);

        label1.setBounds(20, 160, 300, 50);
        label1.setFont(new Font("Arial", Font.BOLD, 20));

        label2.setBounds(20, 300, 300, 50);
        label2.setFont(new Font("Arial", Font.BOLD, 20));

        mpin.setBounds(20, 350, 300, 40);

        button.setBounds(110, 500, 100, 30);
        button.addActionListener(this);

        frame.setSize(360, 708);
        frame.setTitle("GBI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setIconImage(image);
        frame.getContentPane().setBackground(new Color(16, 224, 149));

        frame.add(textField);
        frame.add(label1);
        frame.add(label2);
        frame.add(mpin);
        frame.add(button);
    }
    // Action performed method to handle the submit button click
    @Override
    public void actionPerformed(ActionEvent e) {
        if (textField.getText().equals("22143011017404") && new String(mpin.getPassword()).equals("1234")) {
            frame.dispose();
            new Balance(Balance.balance);
        } else {
            frame.dispose();
            new WrongAccMpin();
        }
    }
}

//Class to handle wrong account number or MPIN entry
class WrongAccMpin implements ActionListener {
    JFrame frame1 = new JFrame();
    JLabel wrongAccount = new JLabel("Please Enter your correct Account No. and MPIN !!");
    JButton back = new JButton("Back");
    // Constructor sets up the UI components for the wrong credentials screen
    WrongAccMpin() {
        wrongAccount.setBounds(20, 160, 300, 50);

        back.setBounds(80, 600, 200, 50);
        back.addActionListener(this);
        back.setBackground(Color.CYAN);
        back.setFont(new Font("Arial",Font.BOLD,30));
        back.setFocusable(false);

        frame1.setSize(360, 708);
        frame1.setTitle("GBI");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(null);
        frame1.setVisible(true);
        frame1.setResizable(false);
        frame1.getContentPane().setBackground(new Color(16, 224, 149));

        frame1.add(wrongAccount);
        frame1.add(back);
    }
    // Action performed method to handle the back button click
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            frame1.dispose();
            new CheckBankBalance();
        }
    }
}

// Class to display the balance
class Balance implements ActionListener {
    JFrame frameBalance = new JFrame();
    JLabel available = new JLabel("Available Main.Balance:");
    JLabel availableBalance;
    JButton home = new JButton("Home");
    ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\bank_1f3e6.png");
    Image image = icon.getImage();
    double money;
    public static double balance = 62205.65;
    // Constructor sets up the UI components for the balance screen
    Balance(double money) {
        this.money=money;
        available.setBounds(20, 20, 300, 200);
        available.setFont(new Font("Arial", Font.BOLD, 30));

        availableBalance = new JLabel("₹ " + this.money);
        availableBalance.setBounds(20, 80, 300, 200);
        availableBalance.setFont(new Font("Arial", Font.BOLD, 35));

        home.setBounds(130, 600, 100, 40);
        home.addActionListener(this);
        home.setFocusable(false);
        home.setFont(new Font("Arial", Font.BOLD, 20));
        home.setBackground(Color.BLUE);

        frameBalance.setSize(360, 708);
        frameBalance.setTitle("GBI");
        frameBalance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameBalance.setLayout(null);
        frameBalance.setVisible(true);
        frameBalance.setResizable(false);
        frameBalance.setIconImage(image);
        frameBalance.getContentPane().setBackground(new Color(16, 224, 149));

        frameBalance.add(available);
        frameBalance.add(availableBalance);
        frameBalance.add(home);
    }
    // Action performed method to handle the home button click
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == home) {
            frameBalance.dispose();
            new Homepage();
        }
    }
}

// Class to handle withdrawal functionality
class Withdraw implements ActionListener{
    JFrame withdrawFrame = new JFrame();
    ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\bank_1f3e6.png");
    Image image = icon.getImage();
    JLabel label = new JLabel("Enter Amount.");
    JLabel mPIN = new JLabel("Enter your 4-digit MPIN");
    JTextField amount = new JTextField();
    JPasswordField setMPIN = new JPasswordField();
    JButton next = new JButton("Next");
    // Constructor sets up the UI components for the withdrawal screen
    Withdraw(){
        label.setBounds(20, 30, 200, 30);

        mPIN.setBounds(20, 150, 200, 30);

        setMPIN.setBounds(20, 190, 200, 30);

        amount.setBounds(20, 70, 200, 30);

        next.setBounds(120, 400, 100, 30);
        next.addActionListener(this);
        next.setBackground(Color.cyan);
        next.setFont(new Font("Arial",Font.BOLD,15));

        withdrawFrame.setSize(360, 708);
        withdrawFrame.setTitle("GBI");
        withdrawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        withdrawFrame.setLayout(null);
        withdrawFrame.setVisible(true);
        withdrawFrame.setResizable(false);
        withdrawFrame.setIconImage(image);
        withdrawFrame.getContentPane().setBackground(new Color(16, 224, 149));

        withdrawFrame.add(label);
        withdrawFrame.add(amount);
        withdrawFrame.add(mPIN);
        withdrawFrame.add(setMPIN);
        withdrawFrame.add(next);
    }
    // Action performed method to handle the next button click
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            if (new String(setMPIN.getPassword()).equals("1234")) {
                double withdrawalAmount = Double.parseDouble(amount.getText());
                if (withdrawalAmount <= Balance.balance) {
                    Balance.balance -= withdrawalAmount;
                    withdrawFrame.dispose();
                    new WithdrawSuccessful();
                } else {
                    JOptionPane.showMessageDialog(withdrawFrame, "Insufficient funds.");
                }
            }
        }
    }
}

// Class to display withdrawal success message
class WithdrawSuccessful implements ActionListener {
    JFrame successWithdraw = new JFrame();
    JLabel successLabel = new JLabel("Withdraw Successful...!!");
    ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\bank_1f3e6.png");
    Image image = icon.getImage();
    JButton home = new JButton("Home");

    // Constructor sets up the UI components for the withdrawal success screen
    WithdrawSuccessful() {
        successLabel.setBounds(20, 160, 300, 50);
        successLabel.setFont(new Font("Arial", Font.BOLD, 20));

        home.setBounds(80, 500, 200, 70);
        home.setFocusable(false);
        home.addActionListener(this);
        home.setBackground(Color.CYAN);
        home.setFont(new Font("Arial",Font.BOLD,35));

        successWithdraw.setSize(360, 708);
        successWithdraw.setTitle("GBI");
        successWithdraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        successWithdraw.setLayout(null);
        successWithdraw.setVisible(true);
        successWithdraw.setResizable(false);
        successWithdraw.setIconImage(image);
        successWithdraw.getContentPane().setBackground(new Color(16, 224, 149));

        successWithdraw.add(successLabel);
        successWithdraw.add(home);
    }
    // Action performed method to handle the home button click
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == home) {
            successWithdraw.dispose();
            new Homepage();
        }
    }
}

// Class to handle deposit functionality
class Deposit implements ActionListener {
    JFrame depositFrame = new JFrame();
    JLabel label = new JLabel("Enter Amount.");
    JLabel mPIN = new JLabel("Enter your 4-digit MPIN");
    JTextField amount = new JTextField();
    JPasswordField setMPIN = new JPasswordField();
    ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\bank_1f3e6.png");
    Image image = icon.getImage();
    JButton next = new JButton("Next");
    // Constructor sets up the UI components for the deposit screen
    Deposit() {
        label.setBounds(20, 30, 200, 30);

        mPIN.setBounds(20, 150, 200, 30);

        setMPIN.setBounds(20, 190, 200, 30);

        amount.setBounds(20, 70, 200, 30);

        next.setBounds(120, 400, 100, 30);
        next.setBackground(Color.cyan);
        next.addActionListener(this);
        next.setFocusable(false);

        depositFrame.setSize(360, 708);
        depositFrame.setTitle("GBI");
        depositFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        depositFrame.setLayout(null);
        depositFrame.setVisible(true);
        depositFrame.setResizable(false);
        depositFrame.setIconImage(image);
        depositFrame.getContentPane().setBackground(new Color(16, 224, 149));

        depositFrame.add(label);
        depositFrame.add(amount);
        depositFrame.add(mPIN);
        depositFrame.add(setMPIN);
        depositFrame.add(next);
    }
    // Action performed method to handle the next button click
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            if (new String(setMPIN.getPassword()).equals("1234")) {
                double depositAmount = Double.parseDouble(amount.getText());
                Balance.balance += depositAmount;
                depositFrame.dispose();
                new DepositSuccessful();
            }
        }
    }
}

// Class to display deposit success message
class DepositSuccessful implements ActionListener {
        JFrame success = new JFrame();
        JLabel successLabel = new JLabel("Deposit Successful...!!");
        ImageIcon icon = new ImageIcon("C:\\Users\\User\\Downloads\\bank_1f3e6.png");
        Image image = icon.getImage();
        JButton home=new JButton("Home");

    // Constructor sets up the UI components for the deposit success screen
    DepositSuccessful() {
            successLabel.setBounds(20, 160, 300, 50);
            successLabel.setFont(new Font("Arial",Font.BOLD,20));

            home.setBounds(53,500,200,70);
            home.setFocusable(false);
            home.setBackground(Color.BLUE);
            home.addActionListener(this);
            home.setFont(new Font("Arial",Font.BOLD,25));

            success.setSize(360, 708);
            success.setTitle("GBI");
            success.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            success.setLayout(null);
            success.setVisible(true);
            success.setResizable(false);
            success.setIconImage(image);
            success.getContentPane().setBackground(new Color(16, 224, 149));

            success.add(successLabel);
            success.add(home);
        }
    // Action performed method to handle the home button click
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==home){
                success.dispose();
                new Homepage();
            }
        }
    }

// Main class to launch the application
public class Main {
    public static void main(String[] args) {
        new Homepage();
    }
}