import java.sql.*;
import java.util.Scanner;

public class DBManager {


//    connect to the mysql database
    public static Connection getConnection() {
        try {

//            input your username for the sql workbench, most likely "root"
            String user = "root";

//            input your workbench password
            String password = "your-password";

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
            while ((resultSet.next())) {
                System.out.println(resultSet.getString("DocID") + " - " + resultSet.getString("Name") + " - " + resultSet.getString("Phone") + " - " +  resultSet.getString("Speciality") + " - " +  resultSet.getString("Gender")  );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        getAllDoc();


    }
}
