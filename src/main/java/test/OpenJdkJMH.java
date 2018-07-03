package test;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Calendar;

/**
 * @author: lingjun.jlj
 * @Date: 2018/6/27 14:16
 * @Description: JMH
 */
public class OpenJdkJMH {

    static int millis = 24 * 3600 * 1000;

    public static void main(String[] args) throws Exception{
        Options options = new OptionsBuilder()
                .include(OpenJdkJMH.class.getName())
                .forks(1)
                .build();
        new Runner(options)
                .run();
    }

    @Benchmark
    @Threads(5)
    public void runCalendar() {
        Calendar calendar = Calendar.getInstance();
    }


    @Benchmark
    @Threads(5)
    public void runSystem() {
        long result = System.currentTimeMillis() / millis;
    }

}
