import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author ZhaoMin
 * @date 2019/10/24 21:21
 */
public class Update {
    public static void main(String[] args) {
        System.out.println(updateStudent("夷陵老祖","老外学中文"));
    }
    public static boolean updateStudent(String name1,String name2){
        Connection connection=null;
        PreparedStatement ps=null;
        try{
            connection=DButil.getConnection();
            String sql="update student set name=? where name=?";
            ps=connection.prepareStatement(sql);
            ps.setString(1,name2);
            ps.setString(2,name1);
            int rs=ps.executeUpdate();
            return rs>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.close(connection,ps);
        }
        return false;
    }
}
