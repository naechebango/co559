import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameLogin {

    JFrame loginFrame = new JFrame();

    Container container = loginFrame.getContentPane();
    JLabel userLabel = new JLabel("Username");
    JTextField userTextField = new JTextField("");
    JLabel passwordLabel = new JLabel("Password");
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JCheckBox showPassword = new JCheckBox("Show Password");

    // launch application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FrameLogin login = new FrameLogin();
                    login.loginFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public FrameLogin() {
        initialise();
        setLocationAndSize();
        addColours();
        addActionEvent();
    }

    private void addActionEvent() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeFrame hf = new HomeFrame();
                hf.homeFrame.setVisible(true);
                loginFrame.dispose();
            }
        });
    }

    private void addColours() {
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.BLACK);
    }

    private void setLocationAndSize() {
        userLabel.setBounds(100, 8, 70, 20);
        userTextField.setBounds(100, 27, 193, 28);
        passwordLabel.setBounds(100, 55, 70, 20);
        passwordField.setBounds(100, 75, 194, 28);
        loginButton.setBounds(100, 110, 90, 25);
        showPassword.setBounds(200, 105, 194, 28);

    }

    public void initialise(){
        loginFrame.setTitle("Login Form");
        loginFrame.setBounds(10, 10, 400, 300);
        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFrame.setResizable(true);

        loginFrame.getContentPane().setLayout(null);

        container.add(userLabel);
        container.add(passwordField);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(loginButton);
        container.add(showPassword);
    }


}