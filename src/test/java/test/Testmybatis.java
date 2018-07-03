package test;

import com.project.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lingjun.jlj
 * @data 2018/4/28
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Testmybatis {

    @Autowired
    private TestService testService;

    @Test
    public void Test(){
        System.out.println(testService.findCityById(1L));
    }
}
