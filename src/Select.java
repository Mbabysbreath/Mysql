import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhaoMin
 * @date 2019/10/24 19:29
 */
public class Select {
    public static void main(String[] args){
        List<Student> students = selectStudent("qq.com", 1);
        System.out.println(students);
        List<Score> students2=selectScore(60,1);
    }

    /**
     * 查询
     * @param mail
     * @param classesId
     * @return
     */
    public static List<Student> selectStudent(String mail,Integer classesId) {
        Connection connection=null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        List<Student> students=new ArrayList<>();
        try {
            connection= DButil.getConnection();;
         String sql="select id,sn,name,qq_mail,classes_id " +
                 "from student " +
                 "where qq_mail like ?and classes_id=?";

            //相比较于Statement，解决了安全漏洞
            ps = connection.prepareStatement(sql);
             rs=ps.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
               student.setSn(rs.getInt("sn"));
               student.setName(rs.getString("name"));
               student.setQqMail(rs.getString("qq_mail"));
                student.setClassId(rs.getInt("classes_id"));
                students.add(student);
                System.out.println(student);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            //如果不放在finally中可能不会执行
            DButil.close(connection, ps);
        }
        return students;
    }
//连接多表查询
    public static List<Score> selectScore(Integer score,Integer classesId){
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Score> scores=new ArrayList<>();
        try{
            connection=DButil.getConnection();
            String sql="SELECT" +
                    " stu.id," +
                    " stu.NAME student_name," +
                    " cou.NAME course_name," +
                    " sco.score " +
                    " FROM" +
                    " score sco" +
                    " JOIN student stu ON sco.student_id = stu.id" +
                    " JOIN course cou ON cou.id = sco.course_id " +
                    " WHERE" +
                    " sco.score >= ? " +
                    " AND stu.classes_id = ?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,score);
            ps.setInt(2,classesId);
            rs=ps.executeQuery();
            while(rs.next()){
                Score score1=new Score();
                score1.setStudentId(rs.getInt("id"));
                score1.setStudentName(rs.getString("student_name"));
                score1.setCourseName(rs.getString("course_name"));
                score1.setScore(rs.getBigDecimal("score"));
                scores.add(score1);
                System.out.println(score1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.close(connection,ps,rs);
        }
        return scores;
    }

    public static List<Student> selectScore2(Integer score,Integer classsesId){
        Connection        connection = null;
        PreparedStatement ps=null;
        ResultSet         rs=null;
        List<Student>     students=new ArrayList<>();
        try{
            connection=DButil.getConnection();
            String sql="SELECT" +
                    " stu.id," +
                    " stu.NAME student_name," +
                    " cou.NAME course_name," +
                    " sco.score " +
                    " FROM" +
                    " score sco" +
                    " JOIN student stu ON sco.student_id = stu.id" +
                    " JOIN course cou ON cou.id = sco.course_id " +
                    " WHERE" +
                    " sco.score >= ? " +
                    " AND stu.classes_id = ?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,score);
            ps.setInt(2,classsesId);
            rs=ps.executeQuery();
            while(rs.next()){
                Student student=new Student();
                Score   score1=new Score();
               Integer  id=rs.getInt("id");
               boolean  isExists=false;
                score1.setScore(rs.getBigDecimal("score"));
                score1.setCourseName(rs.getString("course_name"));
                for(Student student1:students){
                    if(Integer.compare(id,student1.getId())==0){
                        student=student1;
                        isExists=true;
                    }
                }
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("student_name"));
                List<Score> existsScores=student.getScores();
                if(existsScores==null){
                    existsScores=new ArrayList<>();
                }
                existsScores.add(score1);
                if(!isExists){
                    students.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DButil.close(connection,ps,rs);
        }
        return students;
    }
}
