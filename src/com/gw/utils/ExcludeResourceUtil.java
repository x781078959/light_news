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
    static String[] urls = {"/light_news/index","/light_news/info","/info",
            "/user","/light_news/user","/news", "/light_news/news","/index",
            "/type","/light_news/type","/link","/light_news/link",
            ".js",".json",".css",".ico", ".jpg",".png",".gif",".map",
            ".json",".woff",".eot",".woff2", ".ttf",".jsp",".mp4"};

    public static boolean shouldExclude(String uri){
        for (String str : urls) {
            if(uri.contains(str)){
                return true;
            }
        }
        return false;
    }
}
