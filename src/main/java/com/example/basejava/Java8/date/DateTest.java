package com.example.basejava.Java8.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author lingjun.jlj
 * @create 2017-09-22
 **/
public class DateTest {
    public static void main(String[] args){
        //String --> LocalDate
        String str = "2017-08-01";
        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ld = LocalDate.parse(str, dateformatter);
        System.out.println(ld);

        //String -->LocalDateTime
        String s1 = "2017-09-22 11:30:10";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(s1, df);
        System.out.println(ldt);

        //String -->LocalDateTime
        String s2 = "11:30:10";
        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime lt = LocalTime.parse(s1, df);
        System.out.println(lt);

        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);

        LocalDate localDate = localDateTime.toLocalDate();

        LocalTime localTime = localDateTime.toLocalTime();
    }


    // 04. java.time.LocalDateTime --> java.util.Date
    public void LocalDateTimeToUdate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
    }


    // 05. LocalDate --> Date
    public void LocalDateToUdate() {
        LocalDate localDate = LocalDate.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        Date date = Date.from(instant);
    }

    // 06. java.time.LocalTime --> java.util.Date
    public void LocalTimeToUdate() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        LocalDateTime localDateTime1 = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);
    }
}
