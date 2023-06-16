package com.gw.dao;


import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * ClassName: CkeditorImageDAO
 * PackageName: com.gw.dao
 *
 * @Description:
 * @Author: 谢金宸
 * @Create: 2023/6/9 19:17
 * @Version: 1.0
 */
public interface CkeditorImageDAO {
    public String saveTODisk(HttpServletRequest request) throws Exception;
    public BufferedImage getFromDisk(String fileName) throws IOException;
}
