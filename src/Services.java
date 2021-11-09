import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class Services {



    public static Customer getUser() {
        Connection connection = connectionHelper.getconnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(QueryConstant.selectQuery);

            if(rs.next())
            {
                Customer user = new Customer();
                user.setCustomerId( rs.getString("Customer_Id") );
                user.setCustomerName( rs.getString("Customer_Name") );

               user.setmobile(BigInteger.valueOf(rs.getLong("Mobile")));

                user.setEmail( rs.getString("Email") );
                user.setpassword( rs.getString("Password") );
                user.setaddress( rs.getString("address") );
                connectionHelper.closeconnection();
                return user;

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static  void updateCustomer()  {

        Connection connection = connectionHelper.getconnection();
        try {
            PreparedStatement ps = connection.prepareStatement(QueryConstant.updateQuery);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("enter employeeId");
                String strId = br.readLine();
                //int id = Integer.parseInt(strId);
                System.out.println("enter emp_name");
                String strname = br.readLine();
                System.out.println("enter address");
                String address = br.readLine();


                ps.setString(1, strname);
                ps.setString(2, address);
                ps.setString(3,strId);
                int i = ps.executeUpdate();
                System.out.println("updated");





        } catch (SQLException | IOException   ex) {
            ex.printStackTrace();
        }

        connectionHelper.closeconnection();
    }


    public static void insertUser()  {
        Connection connection = connectionHelper.getconnection();

        try {
            PreparedStatement psbatch = connection.prepareStatement(QueryConstant.insertQuery);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("enter employeeId");
                String strId = br.readLine();
                //int id = Integer.parseInt(strId);
                System.out.println("enter emp_name");
                String strname = br.readLine();
                System.out.println("enter mobile");
                String mobile = br.readLine();
                System.out.println("enter Email");
                String Email = br.readLine();
                System.out.println("enter password");
                String password = br.readLine();

                System.out.println("enter address");
                String address = br.readLine();




                psbatch.setString(1, strId);
                psbatch.setString(2, strname);
                psbatch.setString(3, mobile);
                psbatch.setString(4, Email);
                psbatch.setString(5, password);
                //psbatch.setDate(6, date1);
                psbatch.setString(6, address);
                psbatch.addBatch();
                psbatch.executeBatch();
                System.out.println("Want to add more  y/n");
                String ans = br.readLine();
                if (ans.equals("n")) {
                    break;
                }
            }

            System.out.println("record successfully saved");

        } catch (SQLException | IOException   ex) {
            ex.printStackTrace();
        }
        connectionHelper.closeconnection();
        //return false;
    }
    public static  void deleteCustomer()  {

        Connection connection = connectionHelper.getconnection();
        try {
            PreparedStatement ps = connection.prepareStatement(QueryConstant.deleteQuery);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("enter employeeId");
            String strId = br.readLine();



            ps.setString(1, strId);

            int i = ps.executeUpdate();
            System.out.println("deleted");





        } catch (SQLException | IOException   ex) {
            ex.printStackTrace();
        }

        connectionHelper.closeconnection();
    }


}

