package com.xuningxin.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by xnx on 2018/12/26.
 * 时间处理器
 */
public class DateHandler {

    enum DateFormat{
        YEAR_MONTH_DATE_TIME("yyyy-MM-dd HH:mm:ss"){
            public String toString(){
                return this.reg;
            }
        },
        YEAR_MONTH_DAY("yy-MM-dd"){
            public String toString(){
                return this.reg;
            }
        },
        CHINESE_DATE_FORMATER("yyyy年MM月dd日"){
            public String toString(){
                return this.reg;
            }
        };
        ;

        String reg;

        DateFormat(String reg){
            this.reg = reg;
        }

    }



    static Date infinityDate;   // 无限大的时间

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2200);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 1);
        calendar.set(Calendar.MINUTE, 1);
        calendar.set(Calendar.SECOND, 1);
        infinityDate = calendar.getTime();
    }

    public static String formatDateToString(Date date, DateFormat dateFormat) {
        return formatDateToString(date,dateFormat.toString());
    }

    public static String formatDateToString(Date date, String dateFormat) {
        if (date == null)
            return "";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
//        calendar.
        return simpleDateFormat.format(date);
    }

    public static Date transferStrToDate(String date, String format) {
        Date date1 = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            date1 = simpleDateFormat.parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
        return date1;
    }

}
