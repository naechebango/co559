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
    JButton importPButton = new JButton("Import Patient");
    JButton logoutButton = new JButton("Logout");
    JButton makeBooking =  new JButton("Make Booking");
    JButton viewBookings =  new JButton("View Bookings");


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

        importPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FramePatient pf = new FramePatient();
                pf.patientFrame.setVisible(true);
                homeFrame.dispose();
            }
        });

        makeBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameBooking bf = new FrameBooking();
                bf.bookingFrame.setVisible(true);
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

        viewBookings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBManager manager = new DBManager();
                JOptionPane.showMessageDialog(homeFrame, "Date  -  Time  -  Doctor   -   Patient   -  Topic \n" + manager.getAllBookings());
            }
        });
    }

    private void addColours() {
        importDButton.setForeground(Color.WHITE);
        importDButton.setBackground(Color.BLACK);

        importPButton.setForeground(Color.WHITE);
        importPButton.setBackground(Color.BLACK);

        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(Color.BLACK);

        makeBooking.setForeground(Color.WHITE);
        makeBooking.setBackground(Color.BLACK);

        viewBookings.setForeground(Color.WHITE);
        viewBookings.setBackground(Color.BLACK);
    }

    private void setLocationAndSize() {
        welcomeLabel.setBounds(10, 8, 170, 20);
        actionLabel.setBounds(10, 32, 120, 20);
        messagesLabel.setBounds(200, 150, 110, 20);
        importDButton.setBounds(10, 57, 130, 25);
        importPButton.setBounds(10, 90, 130, 25);
        logoutButton.setBounds(290, 10, 77, 25);
        makeBooking.setBounds(10, 123, 130, 25);
        viewBookings.setBounds(10, 156, 130, 25);

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
        container.add(importPButton);
        container.add(viewBookings);
        container.add(makeBooking);
    }


}