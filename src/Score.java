import java.io.FileOutputStream;
import java.math.BigDecimal;

/**
 * @author ZhaoMin
 * @date 2019/10/26 10:47
 */
public class Score {
    private Integer id;
    private BigDecimal score;
    private Integer studentId;//单表
    private Integer courseId;
    private String courseName;//课程名称
    private String studentName;
   /* private Student student;//多表
    private Classes classes;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Score{" +
                ", score=" + score +
                ", studentId=" + studentId +
                ", courseName='" + courseName + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
