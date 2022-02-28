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
//        importDButton.setForeground(Color.WHITE);
//        importDButton.setBackground(Color.BLACK);
    }

    private void setLocationAndSize() {
        nameLabel.setBounds(100, 8, 70, 20);
        nameTextField.setBounds(100, 27, 193, 28);
        numberTextField.setBounds(100, 75, 193, 28);
        genderTextField.setBounds(100, 199, 193, 28);
        specialityTextField.setBounds(100, 157, 193, 28);
        IDTextField.setBounds(100, 115, 193, 28);
        numberLabel.setBounds(100, 55, 200, 20);
        genderLabel.setBounds(100, 180, 194, 28);
        specialityLabel.setBounds(100, 135, 194, 28);
        IDLabel.setBounds(100, 95, 194, 28);
        addDoctor.setBounds(100, 250, 110, 25);
        logoutButton.setBounds(460, 10, 110, 25);

    }

    public void initialise(){
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



    }


}