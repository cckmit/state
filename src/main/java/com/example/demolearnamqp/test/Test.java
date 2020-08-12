package com.example.demolearnamqp.test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test {
    public static void main(String[] args) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());
        System.out.println(LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));
        System.out.println(new Date());

        System.out.println(dateTimeFormatter.getZone());
        System.out.println(dateTimeFormatter.withZone(ZoneId.of("America/New_York")).format(LocalDateTime.now()));

//        2020-08-12T13:48:49.651
//        2020-08-12T13:48:49.654+08:00[Asia/Shanghai]
//        2020-08-12T05:48:49.655Z
//        2020-08-12T13:48:49.697
    }
}