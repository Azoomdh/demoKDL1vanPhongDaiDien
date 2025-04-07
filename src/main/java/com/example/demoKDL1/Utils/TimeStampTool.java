package com.example.demoKDL1.Utils;

import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeStampTool {

    public static Date convertString2DateUtils(String formatString, String timeString1){
        try {
            SimpleDateFormat formatTime= new SimpleDateFormat(formatString) ;
            Date date1= formatTime.parse(timeString1);
            return date1;
        } 
        
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Timestamp convertDateUtils2TimeStamp(Date date1){
        return new Timestamp(date1.getTime());
    }
}
