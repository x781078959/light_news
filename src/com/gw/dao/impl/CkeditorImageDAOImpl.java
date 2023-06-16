package com.gw.dao.impl;


import com.gw.dao.CkeditorImageDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * ClassName: CkeditorImageDAOImpl
 * PackageName: com.gw.dao.impl
 *
 * @Description:
 * @Author: 谢金宸
 * @Create: 2023/6/9 19:18
 * @Version: 1.0
 */
public class CkeditorImageDAOImpl implements CkeditorImageDAO {
    private String dataFilePath;
    private String ckeditorImageServletPath;

    public String getCkeditorImageServletPath() {
        return ckeditorImageServletPath;
    }

    public void setCkeditorImageServletPath(String ckeditorImageServletPath) {
        this.ckeditorImageServletPath = ckeditorImageServletPath;
    }

    public String getDataFilePath() {
        return dataFilePath;
    }

    public void setDataFilePath(String dataFilePath) {
        this.dataFilePath = dataFilePath;
    }

    public String saveTODisk(HttpServletRequest request) throws Exception {
        String imageURL = "";

        // 判断文件夹是否存在，不存在则创建
        File dirTest = new File(dataFilePath);
        if (!dirTest.exists()) {
            dirTest.mkdirs();
        }
        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        try {
            List<FileItem> items = upload.parseRequest((RequestContext) request);
            if (items != null && !items.isEmpty()) {
                FileItem fileItem = items.get(0);//目前ckeditor编辑器只允许同时上传一个图片文件，所以只处理第一个即可

                String fileName = new Date().getTime() + "."
                        + FilenameUtils.getExtension(fileItem.getName());//获取文件扩展名
                File pathToSave = new File(dataFilePath, fileName);
                fileItem.write(pathToSave);

                imageURL = this.ckeditorImageServletPath + fileName;
            }
        } catch (Exception ex) {
            throw ex;
        }
        return imageURL;
    }

    public BufferedImage getFromDisk(String fileName) throws IOException {
        File file = new File(dataFilePath + fileName);
        BufferedImage bufferImage = ImageIO.read(file);
        return bufferImage;
    }
}
