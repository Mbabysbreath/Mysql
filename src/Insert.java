import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author ZhaoMin
 * @date 2019/10/24 20:29
 */
public class Insert {
    public static void main(String[] args) {
        Connection connection=DButil.getConnection();
        PreparedStatement ps=null;
        try{
            String sql="insert into student" +
                    " (id,sn,name,qq_mail,classes_id) values(?,?,?,?,?)";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,9);
            ps.setInt(2,1024);
            ps.setString(3,"夷陵老祖");
            ps.setString(4,"1234@qq.com");
            ps.setInt(5,3);
            int rs=ps.executeUpdate();
            if(rs>0){
                System.out.println("插入成功");
            }else{
                System.out.println("插入失败");
            }
        }catch(SQLException e){
            e.printStackTrace();

        }finally {
            DButil.close(connection,ps);
        }
    }
}
