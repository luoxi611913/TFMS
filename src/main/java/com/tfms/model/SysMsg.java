package com.tfms.model;

public class SysMsg {

    /*
    消息标题
     */
    private String title;

    /*
    消息内容
     */
    private String content;

    /*
    信息
     */
    private String etraInfo;

    public SysMsg(String title, String content, String etraInfo) {
        super();
        this.title = title;
        this.content = content;
        this.etraInfo = etraInfo;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getEtraInfo() {
        return etraInfo;
    }
    public void setEtraInfo(String etraInfo) {
        this.etraInfo = etraInfo;
    }
}
