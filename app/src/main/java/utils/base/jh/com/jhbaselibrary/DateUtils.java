package utils.base.jh.com.jhbaselibrary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018-02-28.
 */

public class DateUtils {


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
}
