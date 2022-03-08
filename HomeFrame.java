import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame {

    JFrame homeFrame = new JFrame();

    Container container = homeFrame.getContentPane();
    JLabel messagesLabel = new JLabel("Your Messages:");
    JLabel actionLabel = new JLabel("Actions:");
    JLabel welcomeLabel = new JLabel("Welcome to the Home Page");
    JButton importDButton = new JButton("Import Doctor");
    JButton logoutButton = new JButton("Logout");


    // launch application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    HomeFrame home = new HomeFrame();
                    home.homeFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public HomeFrame() {
        initialise();
        setLocationAndSize();
        addColours();
        addActionEvent();
    }

    private void addActionEvent() {
        importDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameDoctor df = new FrameDoctor();
                df.doctorFrame.setVisible(true);
                homeFrame.dispose();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameLogin lf = new FrameLogin();
                lf.loginFrame.setVisible(true);
                homeFrame.dispose();
            }
        });
    }

    private void addColours() {
        importDButton.setForeground(Color.WHITE);
        importDButton.setBackground(Color.BLACK);

        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(Color.BLACK);
    }

    private void setLocationAndSize() {
        welcomeLabel.setBounds(10, 8, 170, 20);
        actionLabel.setBounds(10, 32, 120, 20);
        messagesLabel.setBounds(200, 150, 110, 20);
        importDButton.setBounds(10, 57, 130, 25);
        logoutButton.setBounds(290, 10, 77, 25);

    }

    public void initialise(){
        homeFrame.setTitle("Home Page");
        homeFrame.setBounds(10, 10, 400, 300);
        homeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        homeFrame.setResizable(false);
        homeFrame.getContentPane().setLayout(null);

        container.add(messagesLabel);
        container.add(actionLabel);
        container.add(importDButton);
        container.add(welcomeLabel);
        container.add(logoutButton);

    }


}
