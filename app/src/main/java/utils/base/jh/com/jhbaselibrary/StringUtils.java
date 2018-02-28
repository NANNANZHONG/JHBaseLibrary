package utils.base.jh.com.jhbaselibrary;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018-02-27.
 */

public class StringUtils {

    /**
     * 获取uuid
     * @return
     * */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 中文、数字、字母 判断
     *
     * @param str
     * @return
     */
    public static boolean isLetterDigitOrChinese(String str) {
        try {
            String regex = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";
            return str.matches(regex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 验证手机号码
     *
     * @param mobileNumber
     * @return
     */
    public static boolean checkMobileNumber(String mobileNumber) {
        try {
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(mobileNumber);
            if (mobileNumber.length() == 11 && isNum.matches()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
