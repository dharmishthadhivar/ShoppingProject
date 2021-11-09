
    public class QueryConstant {
        public static final String url = "jdbc:mysql://localhost:3306/phpmyadmin";
        public static final String username = "phpmyadmin";
        public static final String password = "root";
        public static final String selectQuery="select * from customer";
        public static final String updateQuery="update customer set Customer_Name =?,address=? where Customer_Id=?";
        public static final String insertQuery= "INSERT INTO customer VALUES ((?),(?),(?),(?),(?),(?))";
        public static final String deleteQuery="delete from customer where Customer_Id=?";
    }


