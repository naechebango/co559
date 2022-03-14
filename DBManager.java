import java.sql.*;
import java.util.Scanner;

public class DBManager {


//    connect to the mysql database
    public static Connection getConnection() {
        try {

//            input your username for the sql workbench, most likely "root"
            String user = "root";

//            input your workbench password
            String password = "Ezenwoye123!";

//            input url to database
            String url = "jdbc:mysql://localhost:3306/comp5590";

//            making the creation
            Connection connection = DriverManager.getConnection(url, user, password);

            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

// get all doctor details from mysql
    public static void getAllDoc(){
        try {
            Connection connection = getConnection();
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from doctors");
            String result;
            while ((resultSet.next())) {
                result = resultSet.getString("DocID") + " - " + resultSet.getString("Name") + " - " + resultSet.getString("Phone") + " - " +  resultSet.getString("Speciality") + " - " +  resultSet.getString("Gender");
                System.out.println(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getAllPat(){
        StringBuilder result = new StringBuilder();
        try {
            Connection connection = getConnection();
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from patients");
            String details;
            while ((resultSet.next())) {
                details = resultSet.getString("PatientID") + " - " + resultSet.getString("Name") + " - " + resultSet.getString("Number") + " - " +  resultSet.getString("PrefDoc") + " - " +  resultSet.getString("Gender");
                System.out.println(details);
                result.append(details);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public String getAllBookings(){
        StringBuilder result = new StringBuilder();
        try {
            Connection connection = getConnection();
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from bookings");
            String details;
            while ((resultSet.next())) {
                details = resultSet.getString("Date") + " - " + resultSet.getString("Time") + " - " + resultSet.getString("Doctor") + " - " +  resultSet.getString("Patient") + " - " + resultSet.getString("Topic") + "\n";
//                System.out.println(details);
                result.append(details);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

//    insert a new row in doctor table
    public void insertDoc(String docId, String name, int number, String speciality, String gender) throws Exception{
        try {
            Connection connection = getConnection();
            assert connection != null;
            PreparedStatement insert = connection.prepareStatement("INSERT INTO `comp5590`.`doctors` (`DocID`, `Name`, `Phone`, `Speciality`, `Gender`) VALUES ('" + docId + "', '" + name + "', '" + number + "', '" + speciality + "', '" + gender + "')");
            insert.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getAllDoc();
    }

    public void insertPat(String patId, String name, int number, String prefDoc, String gender) throws Exception{
        try {
            Connection connection = getConnection();
            assert connection != null;
            PreparedStatement insert = connection.prepareStatement("INSERT INTO `comp5590`.`patients` (`PatientID`, `Name`, `Number`, `PrefDoc`, `Gender`) VALUES ('" + patId + "', '" + name + "', '" + number + "', '" + prefDoc + "', '" + gender + "')");
            insert.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getAllPat();
    }

    public void insertBooking(String date, String time, String doctor, String patient, String topic) throws Exception{
        try {
            Connection connection = getConnection();
            assert connection != null;
            PreparedStatement insert = connection.prepareStatement("INSERT INTO `comp5590`.`bookings` (`Date`, `Time`, `Doctor`, `Patient`, `Topic`) VALUES ('" + date + "', '" + time + "', '" + doctor + "', '" + patient + "', '" + topic + "')");
            insert.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        getAllBookings();
    }

    public static void main(String[] args) throws Exception {
//        Scanner myObj = new Scanner(System.in);
//        String docId = myObj.nextLine();
//        String name = myObj.nextLine();
//        int number = myObj.nextInt();
//
//        Scanner myObj2 = new Scanner(System.in);
//        String speciality = myObj2.nextLine();
//        String gender = myObj2.nextLine();

//        getConnection();
        getAllPat();
        getAllDoc();

    }
}