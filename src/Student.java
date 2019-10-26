import java.util.List;

/**
 * @author ZhaoMin
 * @date 2019/10/26 9:24
 */
public class Student {
    //为啥呢不用int
    private Integer id;
    private Integer sn;
    private String name;
    private String qqMail;
    private Integer classId;
    private Classes classes;//一个学生对应一个班级
    private List<Score> scores;

    public Student(){

    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Classes getClasses() {
        return classes;
    }

    public Student(Integer id, Integer sn, String name, String qqMail, Integer classId){
        this.id=id;
        this.sn=sn;
        this.name=name;
        this.qqMail = qqMail;
        this.classId=classId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQqMail() {
        return qqMail;
    }

    public void setQqMail(String qqMail) {
        this.qqMail = qqMail;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sn=" + sn +
                ", name='" + name + '\'' +
                ", qqMail='" + qqMail + '\'' +
                ", classId=" + classId +
                '}';
    }
}
