package utils.base.jh.com.jhbaselibrary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018-02-28.
 */

public class DateUtils {

    /**
     * 返回格式：yyyy-MM-dd HH:mm:ss long ->string
     *
     * @param time
     * @return
     */
    public static String longToYYYYMMDDHHMMSS(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = new Date(time);
        return format.format(d1);
    }

    /**
     * 返回格式：yyyy-MM-dd HH:mm:ss long ->string
     *
     * @param time
     * @return
     */
    public static String longToYYYYMMDD(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = new Date(time);
        return format.format(d1);
    }

    /**
     * 转换时间  "yyyy-MM-dd HH:mm:ss"  ->   yyyy-MM-dd
     *
     * @param time
     * @return
     */
    public static String yYYYMMDDHHMMSStoYYYYMMDD(String time) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(ymdhms);
            Date date = format.parse(time);
            format = new SimpleDateFormat(ymd);
            return format.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 转换时间  "yyyy-MM-dd HH:mm:ss"  ->   HH:mm:ss
     *
     * @param time
     * @return
     */
    public static String removeHHMMSS(String time) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(ymdhms);
            Date date = format.parse(time);
            format = new SimpleDateFormat(hms);
            return format.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 获取今天的日期 "yyyy-MM-dd"
     *
     * @return
     */
    public static String getYYYYMMDD() {
        return new SimpleDateFormat(ymd).format(new Date());
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }

    /**
     * 获取今天之前的6天
     *
     * @return
     */
    public static List<String> getSixDayToToday() {
        long time = System.currentTimeMillis();
        List<String> weeks = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("MM.dd");
        weeks.add(0, format.format(new Date(time + 24 * 60 * 60 * 1000)));
        for (long i = 0; i < 6; i++) {
            Date data = new Date();
            data.setTime(time - (i * 24 * 60 * 60 * 1000));
            weeks.add(0, format.format(data));
        }
        return weeks;
    }

    /**
     * 获取今天之前的30天
     *
     * @return
     */
    public static List<String> getThirtyDayToToday() {
        long time = System.currentTimeMillis();
        List<String> months = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("MM.dd");
        long startTime = time + 24 * 60 * 60 * 1000;
        for (long i = 0; i < 7; i++) {
            long endTime = startTime - (i * 5 * 24 * 60 * 60 * 1000);
            Date data = new Date(endTime);
            months.add(0, format.format(data));
        }
        return months;
    }

    /**
     * 获取今天之前一年的
     *
     * @return
     */
    public static List<String> getYearToToday() {
        long time = System.currentTimeMillis();
        List<String> years = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("MM.dd");
        long startTime = time + 24 * 60 * 60 * 1000;
        for (long i = 0; i < 7; i++) {
            Date data = new Date();
            data.setTime(startTime - (i * 61 * 24 * 60 * 60 * 1000));
            years.add(0, format.format(data));
        }
        return years;
    }

    private static final String ymdhms = "yyyy-MM-dd HH:mm:ss";
    private static final String ymd = "yyyy-MM-dd";
    private static final String hms = "HH:mm:ss";



    /**
     * 获取图标中最小时间
     *
     * @return
     * @throws ParseException
     */
    public static long getStartDayTime(int type) throws ParseException {
        long time = 0L;
        if (type == 1 || type == 5) {
            time = 24 * 60 * 60 * 1000L;
        } else if (type == 2) {
            time = 6 * 24 * 60 * 60 * 1000L;
        } else if (type == 3) {
            time = 6 * 5 * 24 * 60 * 60 * 1000L;
        } else if (type == 4) {
            time = 6 * 61 * 24 * 60 * 60 * 1000L;
        }
        long fTime = System.currentTimeMillis() + 24 * 60 * 60 * 1000 - time;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(new Date(fTime));
        Date date = format.parse(s);
        return date.getTime();
    }




    public static long longDateToLongYYYYMMDD(long time) {

        try {

            String ts = longToYYYYMMDD(time); // 转成yyyy-MM-dd

            return StringYYYYMMDDToLong(ts);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  time;
    }


    public static long StringYYYYMMDDToLong(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dt = sdf.parse(date);
            return dt.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0L;
    }


    /**
     * yyyy-MM-dd HH:mm:ss 转 yyyy/MM/dd
     *
     * @param date
     * @return
     */
    public static String yYYYMMDDHHMMSSToYYYYMMDD(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");
            Date dt = format.parse(date);
            long time = dt.getTime();

            SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd");
            Date d1 = new Date(time);
            return format2.format(d1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static List<String> getHourList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            if (i < 10) {
                list.add("0" + i);
            } else {
                list.add(i + "");
            }
        }
        return list;
    }

    public static List<String> getMinList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 60; i++) {
            if (i < 10) {
                list.add("0" + i);
            } else {
                list.add(i + "");
            }
        }
        return list;
    }
    private static SimpleDateFormat format = new SimpleDateFormat("mm:ss");

    /**
     * 格式化时间 SimpleDateFormat类很实用的类
     *
     * @param time
     * @return s
     * */
    public static String formatTime(long time) {
        return format.format(time);
    }


    /**
     * 计算当天的时间天数差
     *
     * @param starTime  开始时间
     * @return 返回时间差
     */
    public static int getTimeDifference(String starTime) {
        int timeString = -1;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parse = dateFormat.parse(starTime);
            Date parse1 = new Date();
            long diff = parse1.getTime() - parse.getTime();
            long day = diff / (24 * 60 * 60 * 1000);
            timeString = (int) day;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeString;
    }



    /**
     * 获取今天之前的6天
     *
     * @return
     */
    public static List<String> getDetaToWeek() {
        long time = System.currentTimeMillis();
        List<String> weeks = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("MM.dd");
        weeks.add(0, format.format(new Date(time + 24 * 60 * 60 * 1000)));
        for (long i = 0; i < 6; i++) {
            Date fdate = new Date();
            fdate.setTime(time - (i * 24 * 60 * 60 * 1000));
            weeks.add(0, format.format(fdate));
        }
        return weeks;
    }

    /**
     * 获取 时:分
     *
     * @param time
     * @return
     */
    public static String getTimeOfData(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        StringBuffer sb = new StringBuffer();
        sb.append(DateUtils.getAddZero(hour)).append(":")
                .append(DateUtils.getAddZero(min));
        return sb.toString();
    }
    private static String getAddZero(int str) {
        try {
            String s;
            if (str < 10) {
                s = "0" + str;
            } else {
                s = "" + str;
            }
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(str);
    }


    /**
     * 返回格式： string ->long
     *
     * @param time
     * @return
     */
    public static long stringToLong(String time)throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.parse(time).getTime();
    }




    public static List<Integer> getDateForString(String date) {
        String[] dates = date.split("-");
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(dates[0]));
        list.add(Integer.parseInt(dates[1]));
        list.add(Integer.parseInt(dates[2]));
        return list;
    }

    public static List<Integer> getDateForString2(String date) {
        String[] dates2 = date.split(" ");
        String[] dates = dates2[0].split("-");
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(dates[0]));
        list.add(Integer.parseInt(dates[1]));
        list.add(Integer.parseInt(dates[2]));

        list.add(Integer.parseInt(dates2[1].split(":")[0]));
        list.add(Integer.parseInt(dates2[1].split(":")[1]));
        return list;
    }

    public static long getLongDate(String data) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.parse(data).getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 发送消息时，获取当前事件
     *
     * @return 当前时间
     */
    public static String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }

    /**
     * yyyy-MM-dd HH:mm:ss 转换 yyyy/MM/dd HH:mm:ss
     * @param time
     * @return
     */
    public static String stringTime2Time(String time){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d  = format.parse(time);
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            return format1.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }


    /**
     * 返回格式：yyyy-MM-dd HH:mm:ss long ->string
     *
     * @param time
     * @return
     */
    public static String longToString(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = new Date(time);
        return format.format(d1);
    }

    public static String longToString4(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        Date d1 = new Date(time);
        return format.format(d1);
    }



    /**
     *
     */
    public static String formatDuring(long mss) {
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        //    long seconds = (mss % (1000 * 60)) / 1000;
        StringBuffer sb = new StringBuffer();
        if (days > 0) {
            sb.append(days + "天");
        }
        if (hours > 0) {
            sb.append(hours + "小时");
        }
        if (minutes > 0) {
            sb.append(minutes + "分钟");
        }

        return sb.toString();

        //           + seconds + " seconds ";
    }

    /**
     * yyyy-MM-dd HH:mm:ss 转 MM-dd HH:mm
     *
     * @param date
     * @return
     */
    public static String StringDateToString7(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dt = format.parse(date);
            long time = dt.getTime();

            SimpleDateFormat format2 = new SimpleDateFormat("MM-dd HH:mm");
            Date d1 = new Date(time);
            return format2.format(d1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }


}
