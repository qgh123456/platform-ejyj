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
            Connection conn = DriverManager.getConnection("jdbc:mysql://47.100.7.152:3306/sys?useSSL=false","javademo","123qwe!@#");
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
