package com.farmers.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class DateUtil {
    //获取指定天数
    public static String getTime(int days){
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,days);
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }
}
