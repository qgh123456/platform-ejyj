import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * .
 *
 * @author Mubai
 * @since 2022/8/19 10:48 下午
 **/
public class MysqlTest {
    public static void main(String[] args) {
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://181.31.250.82:3306/micro_system?useSSL=false","root","123456");
            System.out.println(conn);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
