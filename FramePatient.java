import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FramePatient {

    JFrame patientFrame = new JFrame();

    Container container = patientFrame.getContentPane();
    JLabel nameLabel = new JLabel("Full Name");
    JLabel genderLabel = new JLabel("Gender");
    JLabel numberLabel = new JLabel("Phone Number");
    JLabel IDLabel = new JLabel("Patient ID");
    JLabel prefDocLabel = new JLabel("Preferred Doctor");
    JTextField nameTextField = new JTextField();
    JTextField numberTextField = new JTextField();
    JTextField genderTextField = new JTextField();
    JTextField prefDocTextField = new JTextField();
    JTextField IDTextField = new JTextField();
    JButton addPatient = new JButton("Add Patient");
    JButton logoutButton = new JButton("Logout");
    JButton backButton =  new JButton("Back");

    // launch application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FramePatient frame = new FramePatient();
                    frame.patientFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public FramePatient() {
        initialise();
        setLocationAndSize();
        addColours();
        addActionEvent();
    }

    private void addActionEvent() {
        addPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBManager manager = new DBManager();
                try {
                    manager.insertPat(IDTextField.getText(), nameTextField.getText(), Integer.parseInt(numberTextField.getText()), prefDocTextField.getText(), genderTextField.getText());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(patientFrame, nameTextField.getText() + " has been added to the patient database");

                IDTextField.setText("");
                nameTextField.setText("");
                numberTextField.setText("");
                prefDocTextField.setText("");
                genderTextField.setText("");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeFrame hf = new HomeFrame();
                hf.homeFrame.setVisible(true);
                patientFrame.dispose();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameLogin lf = new FrameLogin();
                lf.loginFrame.setVisible(true);
                patientFrame.dispose();
            }
        });
    }

    private void addColours() {
        addPatient.setForeground(Color.WHITE);
        addPatient.setBackground(Color.BLACK);

        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(Color.BLACK);

        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.BLACK);
    }

    private void setLocationAndSize() {
        nameLabel.setBounds(25, 8, 70, 20);
        nameTextField.setBounds(25, 27, 193, 28);
        IDLabel.setBounds(25, 55, 200, 20);
        IDTextField.setBounds(25, 75, 193, 28);
        genderLabel.setBounds(25, 180, 194, 28);
        genderTextField.setBounds(25, 199, 193, 28);
        prefDocLabel.setBounds(25, 135, 194, 28);
        prefDocTextField.setBounds(25, 157, 193, 28);
        numberLabel.setBounds(25, 95, 194, 28);
        numberTextField.setBounds(25, 115, 193, 28);
        addPatient.setBounds(25, 250, 110, 25);
        logoutButton.setBounds(290, 10, 77, 25);
        backButton.setBounds(290, 50, 77, 25);

    }

    public void initialise(){
        patientFrame.setTitle("Enter Patient Details:");
        patientFrame.setBounds(10, 10, 400, 330);
        patientFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        patientFrame.setResizable(false);
        patientFrame.getContentPane().setLayout(null);

        container.add(nameLabel);
        container.add(genderLabel);
        container.add(numberLabel);
        container.add(IDLabel);
        container.add(prefDocLabel);
        container.add(nameTextField);
        container.add(numberTextField);
        container.add(genderTextField);
        container.add(prefDocTextField);
        container.add(IDTextField);
        container.add(addPatient);
        container.add(logoutButton);
        container.add(backButton);
    }


}