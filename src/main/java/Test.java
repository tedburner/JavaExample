import utils.ByteUtils;

import java.io.*;
import java.net.URL;
import java.time.Clock;
import java.util.*;

/**
 * @author lingjun.jlj
 * @data 2018/5/8
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Calendar calendar =Calendar.getInstance();
        calendar.setMinimalDaysInFirstWeek(1530090806);
        System.out.println(calendar.getTimeInMillis());
        final Clock clock = Clock.systemUTC();
        System.out.println( clock.instant() );
        System.out.println( clock.millis() );

    }
}
