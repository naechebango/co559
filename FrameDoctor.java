import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameDoctor {

    JFrame doctorFrame = new JFrame();

    Container container = doctorFrame.getContentPane();
    JLabel nameLabel = new JLabel("Full Name");
    JLabel genderLabel = new JLabel("Gender");
    JLabel numberLabel = new JLabel("Phone Number");
    JLabel IDLabel = new JLabel("Doctor ID");
    JLabel specialityLabel = new JLabel("Speciality");
    JTextField nameTextField = new JTextField();
    JTextField numberTextField = new JTextField();
    JTextField genderTextField = new JTextField();
    JTextField specialityTextField = new JTextField();
    JTextField IDTextField = new JTextField();
    JButton addDoctor = new JButton("Add Doctor");
    JButton logoutButton = new JButton("Logout");
    JButton backButton =  new JButton("Back");

    // launch application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FrameDoctor frame = new FrameDoctor();
                    frame.doctorFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public FrameDoctor() {
        initialise();
        setLocationAndSize();
        addColours();
        addActionEvent();
    }

    private void addActionEvent() {
        addDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBManager manager = new DBManager();
                try {
                    manager.insertDoc(IDTextField.getText(), nameTextField.getText(), Integer.parseInt(numberTextField.getText()), specialityTextField.getText(), genderTextField.getText());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(doctorFrame, nameTextField.getText() + " has been added to the doctor database");

                IDTextField.setText("");
                nameTextField.setText("");
                numberTextField.setText("");
                specialityTextField.setText("");
                genderTextField.setText("");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeFrame hf = new HomeFrame();
                hf.homeFrame.setVisible(true);
                doctorFrame.dispose();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameLogin lf = new FrameLogin();
                lf.loginFrame.setVisible(true);
                doctorFrame.dispose();
            }
        });
    }

    private void addColours() {
        addDoctor.setForeground(Color.WHITE);
        addDoctor.setBackground(Color.BLACK);

        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(Color.BLACK);

        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.BLACK);
    }

    private void setLocationAndSize() {
        nameLabel.setBounds(25, 8, 70, 20);
        nameTextField.setBounds(25, 27, 193, 28);
        numberLabel.setBounds(25, 55, 200, 20);
        numberTextField.setBounds(25, 75, 193, 28);
        genderLabel.setBounds(25, 180, 194, 28);
        genderTextField.setBounds(25, 199, 193, 28);
        specialityLabel.setBounds(25, 135, 194, 28);
        specialityTextField.setBounds(25, 157, 193, 28);
        IDLabel.setBounds(25, 95, 194, 28);
        IDTextField.setBounds(25, 115, 193, 28);
        addDoctor.setBounds(25, 250, 110, 25);
        logoutButton.setBounds(290, 10, 77, 25);
        backButton.setBounds(290, 50, 77, 25);

    }

    public void initialise(){
        doctorFrame.setTitle("Enter Details:");
        doctorFrame.setBounds(10, 10, 400, 330);
        doctorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        doctorFrame.setResizable(false);
        doctorFrame.getContentPane().setLayout(null);

        container.add(nameLabel);
        container.add(genderLabel);
        container.add(numberLabel);
        container.add(IDLabel);
        container.add(specialityLabel);
        container.add(nameTextField);
        container.add(numberTextField);
        container.add(genderTextField);
        container.add(specialityTextField);
        container.add(IDTextField);
        container.add(addDoctor);
        container.add(logoutButton);
        container.add(backButton);
    }


}
