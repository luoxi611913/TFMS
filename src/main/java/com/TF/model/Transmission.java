package com.TF.model;

/**
 * @Author ZhaoJiaLin
 * @Date 18:36 2020/11/15
 **/
public class Transmission {

  /**
   *序号
   */
  private String id;
  /**
   *起始用户
   */
  private String startUser;
  /**
   *跳接端口号
   */
  private String jumperPort;
  /**
   *跳接位置
   */
  private String jumperPosition;
  /**
   *架间1位置
   */
  private String linkOne;
  /**
   *架间2位置
   */
  private String linkTwo;
  /**
   *成端位置
   */
  private String localPort;
  /**
   *设备开通方向
   */
  private String openPath;
  /**
   *信道代号
   */
  private String channelCode;
  /**
   *设备端口号
   */
  private String devicePort;
  /**
   *终点用户
   */
  private String endUser;
  /**
   *全程路由
   */
  private String fullRouting;
  /**
   *备 注
   */
  private String remarks;
  /**
   * 用户ID
   */
  private String userId;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getStartUser() {
    return startUser;
  }

  public void setStartUser(String startUser) {
    this.startUser = startUser;
  }


  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserId() {
    return userId;
  }

  public String getJumperPort() {
    return jumperPort;
  }

  public void setJumperPort(String jumperPort) {
    this.jumperPort = jumperPort;
  }


  public String getJumperPosition() {
    return jumperPosition;
  }

  public void setJumperPosition(String jumperPosition) {
    this.jumperPosition = jumperPosition;
  }


  public String getLinkOne() {
    return linkOne;
  }

  public void setLinkOne(String linkOne) {
    this.linkOne = linkOne;
  }


  public String getLinkTwo() {
    return linkTwo;
  }

  public void setLinkTwo(String linkTwo) {
    this.linkTwo = linkTwo;
  }


  public String getLocalPort() {
    return localPort;
  }

  public void setLocalPort(String localPort) {
    this.localPort = localPort;
  }


  public String getOpenPath() {
    return openPath;
  }

  public void setOpenPath(String openPath) {
    this.openPath = openPath;
  }


  public String getChannelCode() {
    return channelCode;
  }

  public void setChannelCode(String channelCode) {
    this.channelCode = channelCode;
  }


  public String getDevicePort() {
    return devicePort;
  }

  public void setDevicePort(String devicePort) {
    this.devicePort = devicePort;
  }


  public String getEndUser() {
    return endUser;
  }

  public void setEndUser(String endUser) {
    this.endUser = endUser;
  }


  public String getFullRouting() {
    return fullRouting;
  }

  public void setFullRouting(String fullRouting) {
    this.fullRouting = fullRouting;
  }


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

}
