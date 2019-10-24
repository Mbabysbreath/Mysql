import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ZhaoMin
 * @date 2019/10/24 19:29
 */
public class Select {
    public static void main(String[] args) {
        Connection connection=null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        try {
            connection= DButil.getConnection();;
         String sql="select id,sn,name,qq_mail,classes_id " +
                 "from student " +
                 "where qq_mail like ?and classes_id=?";
            //相比较于Statement，解决了安全漏洞
            ps = connection.prepareStatement(sql);
            ps.setString(1,"%qq.com");
            ps.setInt(2,1);
         //   ps.setInt(2,1);
             rs=ps.executeQuery();
            while (rs.next()){
                Integer id=rs.getInt("id");
                Integer sn=rs.getInt("sn");
                String name=rs.getString("name");
                String qqMail=rs.getString("qq_mail");
                String classesId=rs.getString("classes_id");
                System.out.println(
                        String.format("id=%s,sn=%s,name=%s,mail=%s,classesId=%s",id,sn,name,qqMail,classesId));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            //如果不放在finally中可能不会执行
            DButil.close(connection, ps);
        }
    }
}
