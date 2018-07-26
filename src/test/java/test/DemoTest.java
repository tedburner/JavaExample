package test;

import com.project.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/23 14:04
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DemoTest {

    @Autowired
    private TestService testService;

    @Test
    public void test(){
        testService.addAddress();
    }

}
