package utils.base.jh.com.jhbaselibrary;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2018-02-28.
 */

public class ListViewUtils {

    /**
     * ListView 在 ScrollView 下 只显示一行 问题解决办法
     * 双ListView 显示不全问题解决方法
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        try {
            ListAdapter listAdapter = listView.getAdapter();
            if (listAdapter == null) {
                return;
            }
            int totalHeight = 0;
            for (int i = 0; i < listAdapter.getCount(); i++) {
                View listItem = listAdapter.getView(i, null, listView);
                listItem.measure(0, 0);
                totalHeight += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
            listView.setLayoutParams(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
