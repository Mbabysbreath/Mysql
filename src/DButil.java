import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.text.ParseException;

/**
 * JDBC连接：数据库连接的两种方式
 * @author ZhaoMin
 * @date 2019/10/22 20:45
 */
public class DButil {
    private static final String URL="jdbc:mysql://localhost:3306/test0925";
    private static final String USER_NAME="root";
    private static final String PASSWORD="419423mmzz";
    //获取单例连接
    private static DataSource DATASOURCE=new MysqlDataSource();
    static {
        ((MysqlDataSource)DATASOURCE).setURL(URL);
        ((MysqlDataSource)DATASOURCE).setUser(USER_NAME);
        ((MysqlDataSource)DATASOURCE).setPassword(PASSWORD);
    }

    /**
     * 封装一个获取Connection对象的方法，进行数据库连接
     * 1.Class.forName("com.mysql.jdbc.Driver);
     * DriverManager.getConection();
     * 2.DataSource：不用每次创建连接和关闭连接
     * @return
     */
    public static Connection getConnection()  {
        try{
            return DATASOURCE.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            //要抛出一个异常
            throw new RuntimeException("获取数据库连接失败");
        }
    }
    public static void close(Connection connection,PreparedStatement ps,ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(connection!=null){
                connection.close();
            }
        }catch (SQLException e){
            System.out.println("数据库释放失败");
        }
    }
    public static void close(Connection connection,PreparedStatement ps){
        close(connection,ps,null);
    }


    /**
     * 1.加载驱动
     * 2.创建连接//释放
     * 3.创建执行对象Statement//释放
     * 4.执行sql
     * 5.处理结果集
     * 6.释放资源
     * @param args
     */
    public static void main(String[] args) {
//第一种：
        /*Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager
                    .getConnection(URL,USER_NAME,PASSWORD);
            System.out.println(connection);
             statement=connection.createStatement();
            String sql="select * from student";
            resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                Integer id=resultSet.getInt(1);
                Integer sn=resultSet.getInt(2);
                String name=resultSet.getString(3);
                String qq=resultSet.getString(4);
                Integer classesId = resultSet.getInt(5);
                System.out.println(String.format("id=%s,sn=%s,name=%s," +
                        "qq=%s,classesId=%s",id,sn,name,qq,classesId));

            }
        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }finally {
            //注意关闭顺序:结果集/执行对象/连接
            try {
                if(resultSet!=null)
                resultSet.close();
                if(statement!=null)
                statement.close();
                if(statement!=null)
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        */
    }
}
