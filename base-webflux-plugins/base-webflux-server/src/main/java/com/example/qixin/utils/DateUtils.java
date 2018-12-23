package com.example.qixin.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 创  建   时  间： 2018/12/23 13:02
 * 版           本: V1.0
 * 作           者: qixin
 * 版  权   所  有: 版权所有(C)2016-2026
 */
public class DateUtils {

    public static Date parse(String source,Integer zoneHour){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = new GregorianCalendar();
        try {
            Date date = sdf.parse(source);
            c.setTime(date);
        }catch (Exception e){
            c.setTime(new Date());
            e.printStackTrace();
        }
        c.add(Calendar.HOUR_OF_DAY,zoneHour);
        return c.getTime();
    }

    /**
     * 获得指定类型的开始时间
     * @param type 1:全年 2:本月 3:本周 4:今日
     * @param zoneHour 时区
     * @return 时间对象
     */
    public static Date startTime(Integer type,Integer zoneHour){
        if(type==1){
            return getCurrYearFirst(zoneHour);
        }else if(type==2){
            return getCurrMonthFirst(zoneHour);
        }else if(type==3){
            return getCurrWeekFirst(zoneHour);
        }else if(type==4){
            return getCurrDayFirst(zoneHour);
        }else{
            return null;
        }
    }

    /**
     * 获得指定类型的开始时间
     * @param type 1:全年 2:本月 3:本周 4:今日
     * @param zoneHour 时区
     * @return 时间对象
     */
    public static Date endTime(Integer type,Integer zoneHour){
        if(type==1){
            return getCurrYearLast(zoneHour);
        }else if(type==2){
            return getCurrMonthLast(zoneHour);
        }else if(type==3){
            return getCurrWeekLast(zoneHour);
        }else if(type==4){
            return getCurrDayLast(zoneHour);
        }else{
            return null;
        }
    }

    /**
     * 获得一天的开始时间
     * @return 如：2018-11-30 00:00:00
     */
    public static Date getCurrDayFirst(Integer zoneHour){
        Calendar c = new GregorianCalendar();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.add(Calendar.HOUR_OF_DAY,zoneHour);
        return c.getTime();
    }

    /**
     * 获得一天的结束时间
     * @return 如：2018-11-30 23:59:59
     */
    public static Date getCurrDayLast(Integer zoneHour){
        Calendar c1 = new GregorianCalendar();
        c1.set(Calendar.HOUR_OF_DAY, 23);
        c1.set(Calendar.MINUTE, 59);
        c1.set(Calendar.SECOND, 59);
        c1.add(Calendar.HOUR_OF_DAY,zoneHour);
        return c1.getTime();
    }

    /**
     * 获得当前时间周期的第一天
     * @return 如：当前是11.30 第一天为:2018-11-26 00:00:00
     */
    public static Date getCurrWeekFirst(Integer zoneHour){
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.add(Calendar.HOUR_OF_DAY,zoneHour);
        return c.getTime();
    }

    /**
     * 获得当前时间周期的最后一天
     * @return 如：当前是11.30  最后一天为:2018-12-02 23:59:59
     */
    public static Date getCurrWeekLast(Integer zoneHour){
        Calendar c1 = new GregorianCalendar();
        c1.setFirstDayOfWeek(Calendar.MONDAY);
        c1.set(Calendar.DAY_OF_WEEK, c1.getFirstDayOfWeek() + 6); // Sunday
        c1.set(Calendar.HOUR_OF_DAY, 23);
        c1.set(Calendar.MINUTE, 59);
        c1.set(Calendar.SECOND, 59);
        c1.add(Calendar.HOUR_OF_DAY,zoneHour);
        return c1.getTime();
    }

    /**
     * 获得当月第一天
     * @return 如：2018-11-01 00:00:00
     * @author qixin
     */
    public static Date getCurrMonthFirst(Integer zoneHour){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.HOUR_OF_DAY,zoneHour);
        return calendar.getTime();
    }
    /**
     * 获得当月最后一天
     * @return 如：2018-11-30 23:59:59
     * @author qixin
     */
    public static Date getCurrMonthLast(Integer zoneHour){
        Calendar calendar = Calendar.getInstance();
        int value = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, value);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.add(Calendar.HOUR_OF_DAY,zoneHour);
        return calendar.getTime();
    }


    /**
     * 获得当年第一天
     * @return 如：2018-01-01 00:00:00
     * @author qixin
     */
    public static Date getCurrYearFirst(Integer zoneHour){
        Calendar currCal=Calendar.getInstance();
        int year = currCal.get(Calendar.YEAR);
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.add(Calendar.HOUR_OF_DAY,zoneHour);
        return calendar.getTime();
    }

    /**
     * 获得当年的最后一天
     * @return 如：2018-12-31 23:59:59
     * @author qixin
     */
   public static Date getCurrYearLast(Integer zoneHour){
       Calendar currCal=Calendar.getInstance();
       int year = currCal.get(Calendar.YEAR);
       Calendar calendar = Calendar.getInstance();
       calendar.clear();
       calendar.set(Calendar.YEAR, year);
       calendar.roll(Calendar.DAY_OF_YEAR, -1);
       calendar.set(Calendar.HOUR_OF_DAY, 23);
       calendar.set(Calendar.MINUTE, 59);
       calendar.set(Calendar.SECOND, 59);
       calendar.add(Calendar.HOUR_OF_DAY,zoneHour);
       return calendar.getTime();
   }
}
