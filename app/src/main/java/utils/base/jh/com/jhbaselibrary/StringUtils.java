package utils.base.jh.com.jhbaselibrary;

import java.util.UUID;

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
}
