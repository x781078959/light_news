package com.gw.pojo;

/**
 * ClassName: Type
 * PackageName: com.gw.pojo
 * Description:
 * <p>
 *
 * @ Author: 谢金宸
 * @ Create: 2023.4.14 - 上午 10:02
 * @ Version: 1.0
 */
public class NewsType {
    private int newsTypeId;
    private String typeName;


    public int getNewsTypeId() {
        return newsTypeId;
    }

    public void setNewsTypeId(int newsTypeId) {
        this.newsTypeId = newsTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String toString() {
        return "NewsType{" +
                "newsTypeId=" + newsTypeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
