import java.sql.*;

/**
 * @author ZhaoMin
 * @date 2019/10/22 20:45
 */
public class DButil {
    private static final String URL="jdbc:mysql://localhost:3306/test0925";
    private static final String USER_NAME="root";
    private static final String PASSWORD="419423mmzz";
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
        Connection connection=null;
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
            //注意关闭顺序
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
    }
}
