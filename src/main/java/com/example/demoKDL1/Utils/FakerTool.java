package com.example.demoKDL1.Utils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

import com.github.javafaker.Faker;

public class FakerTool {

    public static String getFullname(){
        Faker faker1= new Faker();

        return faker1.name().fullName();
    }

    public static String getLastName(){
        Faker faker1= new Faker();

        return faker1.name().lastName();
    }

    public static String getFirstName(){
        Faker faker1= new Faker();

        return faker1.name().firstName();
    }

    public static Timestamp getTimeStampBetween(String minDate, String maxDate){
        Faker faker1 = new Faker();

        Date min_DateUtil = 
            TimeStampTool
                .convertString2DateUtils(
                    "dd:MM:yyyy HH:mm:ss",
                    minDate
                )
            ;  

        Date max_DateUtil =
            TimeStampTool
                .convertString2DateUtils(
                    "dd:MM:yyyy HH:mm:ss",
                    maxDate
                )
            ;


        Timestamp timeRandom = 
            TimeStampTool.convertDateUtils2TimeStamp(
                faker1.date()
                    .between(
                        min_DateUtil,
                        max_DateUtil
                    )
            )
            ;

        return timeRandom;
    }

    public static Long getIdBetween(Long idMin, Long idMax){
        Random random1 = new Random();
        Long idRandom = random1.nextLong(idMax-idMin) +idMin;
        return idRandom;
    }

    public static String getAddress(){
        Faker faker1= new Faker();

        String address1= faker1.address().fullAddress();

        return address1;
    }

}
