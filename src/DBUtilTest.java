import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author ZhaoMin
 * @date 2019/10/26 9:12
 */
public class DBUtilTest {
    @Test
    public void testConnection() {
        Connection connection= DButil.getConnection();
       Assert.assertNotNull(connection);
       // Assert.assertNotNull(new Object());
    }

    @Test
    public void testSelectScore(){
        List<Score> list = Select.selectScore(60, 1);
        System.out.println(list);
        Assert.assertTrue(list.size()==9);
    }

    @Test
    public void testSelectScore2() {
        List<Student> list=Select.selectScore2(60,1);
        System.out.println(list.size());
    }
}
