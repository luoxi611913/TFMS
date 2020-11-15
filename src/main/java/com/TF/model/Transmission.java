package com.TF.model;

/**
 * @Author ZhaoJiaLin
 * @Date 18:36 2020/11/15
 * @Param
 * @return
 **/
public class Transmission {

  private String id;
  private String startUser;
  private String jumperPort;
  private String jumperPosition;
  private String linkOne;
  private String linkTwo;
  private String localPort;
  private String openPath;
  private String channelCode;
  private String devicePort;
  private String endUser;
  private String fullRouting;
  private String remarks;


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
