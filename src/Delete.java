import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author ZhaoMin
 * @date 2019/10/24 21:21
 */
public class Delete {
    public static void main(String[] args) {
        System.out.println(deleteStudent("夷陵老祖",3));
    }
    public static boolean deleteStudent(String name,Integer classId){
        Connection connection=null;
        PreparedStatement ps=null;
        try{
            connection=DButil.getConnection();
            String sql="delete from student where name=? and classes_id=?";
            ps=connection.prepareStatement(sql);
            ps.setString(1,name);
            ps.setInt(2,classId);
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
