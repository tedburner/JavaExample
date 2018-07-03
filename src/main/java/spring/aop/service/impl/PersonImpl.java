package spring.aop.service.impl;

import org.springframework.stereotype.Service;
import spring.aop.service.Speakable;

/**
 * @author lingjun.jlj
 * @data 2018/5/9
 * @Description:
 */
@Service
public class PersonImpl implements Speakable {

    @Override
    public void sayHi() {
        try {
            Thread.currentThread().sleep(30);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hi!!");
    }

    @Override
    public void sayBye() {
        try {
            Thread.currentThread().sleep(10);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Bye!!");
    }
}
