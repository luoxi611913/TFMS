import com.TF.dao.TestDao;
import com.TF.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Test01 {
    @Test
    public void test() throws IOException {

        //获取applicationContext对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取UserDao对象
        TestDao userDao = (TestDao) applicationContext.getBean(TestDao.class);

        //执行方法
        System.out.println(userDao.userCount());

    }
}