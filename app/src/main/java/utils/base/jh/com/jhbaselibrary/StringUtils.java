package utils.base.jh.com.jhbaselibrary;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018-02-27.
 */

public class StringUtils {

    /**
     * 蓝牛协议
     * @param context
     * @return
     */
    public static String getHtmlProtocol(Context context,String name) {
        try {
            InputStream in = context.getAssets().open(name);

            StringBuffer out = new StringBuffer();
            byte[] b = new byte[4096];
            for (int n; (n = in.read(b)) != -1; ) {
                out.append(new String(b, 0, n));
            }
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }



    public static void lengthFilter(final int max_length,final Context context,
                                    final EditText editText) {
        final String err_msg = "超过长度";

        InputFilter[] filters = new InputFilter[1];

        filters[0] = new InputFilter.LengthFilter(max_length) {

            @Override
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                int destLen = dest.length(); // 获取字符个数(一个中文算2个字符)

                int sourceLen = source.length();

                if (destLen + sourceLen > max_length) {
                    Toast.makeText(context,err_msg,Toast.LENGTH_SHORT).show();
                    return "";
                }
                return source;
            }
        };
        editText.setFilters(filters);
    }


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
