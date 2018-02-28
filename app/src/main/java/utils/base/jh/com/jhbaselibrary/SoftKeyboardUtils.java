package utils.base.jh.com.jhbaselibrary;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Administrator on 2018-02-28.
 */

public class SoftKeyboardUtils {

    /**
     * 隐藏软键盘 hideSoftInputView
     *
     * @Title: hideSoftInputView
     * @Description: TODO
     * @param
     * @return void
     * @throws
     */
    public static void hideSoftInputView(Activity activity) {


        InputMethodManager manager = ((InputMethodManager) activity
                .getSystemService(Activity.INPUT_METHOD_SERVICE));
        if (activity.getCurrentFocus() != null)
            manager.hideSoftInputFromWindow(activity.getCurrentFocus()
                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }


    /**
     * 隐藏软键盘
     *
     * @param activity
     * @param view
     */
    public static void hideSoftInputView(Activity activity,View view) {
        InputMethodManager inputMethodManager =
                (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
