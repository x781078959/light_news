package com.gw.utils;

/**
 * ClassName: ExcludeResourceUtil
 * PackageName: com.javaweb.student.util
 * Description:
 *
 * @Author: 谢金宸
 * @Create: 2023.4.30 下午 1:18
 * @Version: 1.0
 */
public class ExcludeResourceUtil {
    static String[] urls = {".js",".css",".ico",".jpg",".png"};

    public static boolean shouldExclude(String uri){
        for (String str : urls) {
            if(uri.contains(str)){
                return true;
            }
        }
        return false;
    }
}
