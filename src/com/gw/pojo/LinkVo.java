package com.gw.pojo;

/**
 * ClassName: LinkVo
 * PackageName: com.gw.pojo
 * Description:
 *
 * @Author: 谢金宸
 * @Create: 2023.5.4 下午 10:16
 * @Version: 1.0
 */
public class LinkVo {
    private int linkId;
    private String linkName;
    private String linkUrl;
    private String linkEmail;
    private int orderNum;

    @Override
    public String toString() {
        return "LinkVo{" +
                "linkId=" + linkId +
                ", linkName='" + linkName + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                ", linkEmail='" + linkEmail + '\'' +
                ", orderNum=" + orderNum +
                '}';
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkEmail() {
        return linkEmail;
    }

    public void setLinkEmail(String linkEmail) {
        this.linkEmail = linkEmail;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
}
