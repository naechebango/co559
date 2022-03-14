import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameBooking {

    JFrame bookingFrame = new JFrame();

    Container container = bookingFrame.getContentPane();

    JLabel topicLabel = new JLabel("Topic of Appointment");
    JLabel docLabel = new JLabel("Doctor");
    JLabel dateLabel = new JLabel("Booking Date");
    JLabel timeLabel = new JLabel("Booking Time");
    JLabel patientLabel = new JLabel("Patient");
    JTextField topicTextField = new JTextField();
    JTextField timeTextField = new JTextField();
    JTextField dateTextField = new JTextField();
    JTextField docTextField = new JTextField();
    JTextField patientTextField = new JTextField();
    JButton addBooking = new JButton("Add Booking");
    JButton logoutButton = new JButton("Logout");
    JButton backButton =  new JButton("Back");

    // launch application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FrameBooking frame = new FrameBooking();
                    frame.bookingFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FrameBooking() {
        initialise();
        setLocationAndSize();
        addColours();
        addActionEvent();
    }

    private void addActionEvent() {
        addBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBManager manager = new DBManager();
                try {
                    manager.insertBooking(dateTextField.getText(), timeTextField.getText(), docTextField.getText(), patientTextField.getText(), topicTextField.getText());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(bookingFrame, "This Booking has created");

                dateTextField.setText("");
                timeTextField.setText("");
                docTextField.setText("");
                patientTextField.setText("");
                topicTextField.setText("");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeFrame hf = new HomeFrame();
                hf.homeFrame.setVisible(true);
                bookingFrame.dispose();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameLogin lf = new FrameLogin();
                lf.loginFrame.setVisible(true);
                bookingFrame.dispose();
            }
        });
    }

    private void addColours() {
        addBooking.setForeground(Color.WHITE);
        addBooking.setBackground(Color.BLACK);

        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(Color.BLACK);

        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.BLACK);
    }

    private void setLocationAndSize() {
        dateLabel.setBounds(25, 8, 100, 20);
        dateTextField.setBounds(25, 27, 193, 28);
        timeLabel.setBounds(25, 55, 200, 20);
        timeTextField.setBounds(25, 75, 193, 28);
        topicLabel.setBounds(25, 95, 300, 28);
        topicTextField.setBounds(25, 115, 193, 28);
        docLabel.setBounds(25, 135, 194, 28);
        docTextField.setBounds(25, 157, 193, 28);
        patientLabel.setBounds(25, 180, 194, 28);
        patientTextField.setBounds(25, 202, 193, 28);
        logoutButton.setBounds(290, 10, 77, 25);
        backButton.setBounds(290, 50, 77, 25);
        addBooking.setBounds(25, 250, 110, 25);
    }

    public void initialise(){
        bookingFrame.setTitle("Enter Booking Details:");
        bookingFrame.setBounds(10, 10, 400, 330);
        bookingFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        bookingFrame.setResizable(false);
        bookingFrame.getContentPane().setLayout(null);

        container.add(topicLabel);
        container.add(topicTextField);
        container.add(dateLabel);
        container.add(dateTextField);
        container.add(timeLabel);
        container.add(timeTextField);
        container.add(docLabel);
        container.add(docTextField);
        container.add(patientLabel);
        container.add(patientTextField);
        container.add(addBooking);
        container.add(logoutButton);
        container.add(backButton);
    }


}