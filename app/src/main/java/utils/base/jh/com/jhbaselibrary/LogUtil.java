package utils.base.jh.com.jhbaselibrary;

import android.util.Log;

public class LogUtil {

    private static boolean printLog(){
       try{
           return BuildConfig.DEBUG;
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
    }

    public static void d(String tag, String msg) {
        if (printLog()) {
            Log.d(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (printLog()) {
            Log.e(tag, msg);
        }
    }

    public static void d(Object object, String msg) {
        if (printLog()) {
            Log.d(getClassName(object), msg);
        }
    }

    public static void e(Object object, String msg) {
        if (printLog()) {
            Log.e(getClassName(object), msg);
        }
    }

    private static String getClassName(Object object) {
        return object.getClass().getSimpleName();
    }
}
