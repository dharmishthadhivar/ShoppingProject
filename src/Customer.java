import java.math.BigInteger;
import java.sql.Date;

public class Customer {

    private String CustomerId;
    private String CustomerName;
    private BigInteger Mobile;
    private String  Email;
    private String  password;
   // private Date CreatedDate;
    private String address;

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String  CustomerId) {
        this.CustomerId = CustomerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String Customername) {
        this.CustomerName = Customername;
    }
    public BigInteger getMobile() {
        return Mobile;
    }

    public void setmobile(BigInteger mobile) {
        this.Mobile = mobile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerId=" + CustomerId +
                ",CustomerName='" + CustomerName + '\'' +
                ",Mobile='" + Mobile + '\'' +
                ",Email='" + Email + '\'' +
                ",Password='" + password + '\'' +
                ",address='" + address + '\'' +
                '}';
    }
}
