package utils.base.jh.com.jhbaselibrary;

import java.io.File;

/**
 * Created by Administrator on 2018-02-28.
 */

public class FileUtils {

    // Java文件操作 获取不带扩展名的文件名
    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }

    //判断文件是否存在
    public static boolean fileIsExists(String strFile) {
        try {
            File f=new File(strFile);
            if(!f.exists()) {
                return false;
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
