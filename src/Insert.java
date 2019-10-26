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
        Student student=new Student();
        student.setName("夷陵老祖");
        student.setId(9);
        student.setClassId(3);
        student.setQqMail("123@qq.com");
        student.setSn(2019);
        System.out.println(insertStudent(student));

    }
    public static boolean insertStudent(Student student){
        Connection connection=DButil.getConnection();
        PreparedStatement ps=null;
        try{
            String sql="insert into student" +
                    " (id,sn,name,qq_mail,classes_id) values(?,?,?,?,?)";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,student.getId());
            ps.setInt(2,student.getSn());
            ps.setString(3,student.getName());
            ps.setString(4,student.getQqMail());
            ps.setInt(5,student.getClassId());
            int rs=ps.executeUpdate();
            return rs>0;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DButil.close(connection,ps);
        }
        return false;
    }

}
