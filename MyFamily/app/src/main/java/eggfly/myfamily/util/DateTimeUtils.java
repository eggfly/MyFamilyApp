package eggfly.myfamily.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DateTimeUtils {

    /**
     * 🏠🏡🌻🍭🍼
     *
     * @param birthday
     * @return
     */
    public static String getAgeString(Date birthday) {
        LocalDate now = LocalDate.now();
        LocalDate birthdayLocal = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(birthdayLocal, now);
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        StringBuilder builder = new StringBuilder("辰辰");
        if (years > 0) {
            builder.append(years).append("岁");
        }
        if (months > 0) {
            builder.append(months).append("个月");
        }
        if (days > 0) {
            builder.append(days).append("天");
        }
        builder.append("了\uD83C\uDF7C"); // 🍼
        return builder.toString();
    }

    private static long getDaysDiff(Date date1, Date date2) {
        return computeDiff(date1, date2).get(TimeUnit.DAYS);
    }

    private static Map<TimeUnit, Long> computeDiff(Date date1, Date date2) {
        long diffInMilliseconds = date2.getTime() - date1.getTime();
        //create the list
        List<TimeUnit> units = new ArrayList<>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);

        //create the result map of TimeUnit and difference
        Map<TimeUnit, Long> result = new LinkedHashMap<TimeUnit, Long>();
        long millisRest = diffInMilliseconds;

        for (TimeUnit unit : units) {
            //calculate difference in millisecond
            long diff = unit.convert(millisRest, TimeUnit.MILLISECONDS);
            long diffInMillisForUnit = unit.toMillis(diff);
            millisRest = millisRest - diffInMillisForUnit;
            //put the result in the map
            result.put(unit, diff);
        }
        return result;
    }

    public static String getWeek() {
        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date());
        int year = cd.get(Calendar.YEAR); //获取年份
        int month = cd.get(Calendar.MONTH); //获取月份
        int day = cd.get(Calendar.DAY_OF_MONTH); //获取日期
        int week = cd.get(Calendar.DAY_OF_WEEK); //获取星期
        String weekString;
        switch (week) {
            case Calendar.SUNDAY:
                weekString = "周日";
                break;
            case Calendar.MONDAY:
                weekString = "周一";
                break;
            case Calendar.TUESDAY:
                weekString = "周二";
                break;
            case Calendar.WEDNESDAY:
                weekString = "周三";
                break;
            case Calendar.THURSDAY:
                weekString = "周四";
                break;
            case Calendar.FRIDAY:
                weekString = "周五";
                break;
            default:
                weekString = "周六";
                break;
        }
        return weekString;
    }
}
