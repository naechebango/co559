import javax.swing.*;

public class DoctorFrame {
    public DoctorFrame() {
    }

    public static void main(String[] args) {
        Doctor frame = new Doctor();
        frame.setTitle("Register New Doctor");
        frame.setVisible(true);
        frame.setBounds(80, 80, 600, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

}
