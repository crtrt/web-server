package com.example.demo.domain;

import java.sql.Timestamp;

public class SysUser {

  private int ID;
  private int ORG_ID;
  private int CLIENT_ID;
  private String UserName;
  private String Password;
  private String REAL_NAME;
  private String SEX;
  private String EMAIL;
  private String PHONE;
  private String MOBILE;
  private String DESCRIPTION;
  private String ISACTIVE;
  private java.sql.Timestamp CREATED;
  private long CREATEBY;
  private java.sql.Timestamp UPDATED;
  private long UPDATEBY;
  private String REMOVE;
  private String DATAFILTER;
  private String theme;
  private String defaultpage;
  private String logoimage;
  private String qqopenid;
  private String appversion;
  private String jsonauth;

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public int getORG_ID() {
    return ORG_ID;
  }

  public void setORG_ID(int ORG_ID) {
    this.ORG_ID = ORG_ID;
  }

  public int getCLIENT_ID() {
    return CLIENT_ID;
  }

  public void setCLIENT_ID(int CLIENT_ID) {
    this.CLIENT_ID = CLIENT_ID;
  }

  public String getUserName() {
    return UserName;
  }

  public void setUserName(String userName) {
    UserName = userName;
  }

  public String getPassword() {
    return Password;
  }

  public void setPassword(String password) {
    Password = password;
  }

  public String getREAL_NAME() {
    return REAL_NAME;
  }

  public void setREAL_NAME(String REAL_NAME) {
    this.REAL_NAME = REAL_NAME;
  }

  public String getSEX() {
    return SEX;
  }

  public void setSEX(String SEX) {
    this.SEX = SEX;
  }

  public String getEMAIL() {
    return EMAIL;
  }

  public void setEMAIL(String EMAIL) {
    this.EMAIL = EMAIL;
  }

  public String getPHONE() {
    return PHONE;
  }

  public void setPHONE(String PHONE) {
    this.PHONE = PHONE;
  }

  public String getMOBILE() {
    return MOBILE;
  }

  public void setMOBILE(String MOBILE) {
    this.MOBILE = MOBILE;
  }

  public String getDESCRIPTION() {
    return DESCRIPTION;
  }

  public void setDESCRIPTION(String DESCRIPTION) {
    this.DESCRIPTION = DESCRIPTION;
  }

  public String getISACTIVE() {
    return ISACTIVE;
  }

  public void setISACTIVE(String ISACTIVE) {
    this.ISACTIVE = ISACTIVE;
  }

  public Timestamp getCREATED() {
    return CREATED;
  }

  public void setCREATED(Timestamp CREATED) {
    this.CREATED = CREATED;
  }

  public long getCREATEBY() {
    return CREATEBY;
  }

  public void setCREATEBY(long CREATEBY) {
    this.CREATEBY = CREATEBY;
  }

  public Timestamp getUPDATED() {
    return UPDATED;
  }

  public void setUPDATED(Timestamp UPDATED) {
    this.UPDATED = UPDATED;
  }

  public long getUPDATEBY() {
    return UPDATEBY;
  }

  public void setUPDATEBY(long UPDATEBY) {
    this.UPDATEBY = UPDATEBY;
  }

  public String getREMOVE() {
    return REMOVE;
  }

  public void setREMOVE(String REMOVE) {
    this.REMOVE = REMOVE;
  }

  public String getDATAFILTER() {
    return DATAFILTER;
  }

  public void setDATAFILTER(String DATAFILTER) {
    this.DATAFILTER = DATAFILTER;
  }

  public String getTheme() {
    return theme;
  }

  public void setTheme(String theme) {
    this.theme = theme;
  }

  public String getDefaultpage() {
    return defaultpage;
  }

  public void setDefaultpage(String defaultpage) {
    this.defaultpage = defaultpage;
  }

  public String getLogoimage() {
    return logoimage;
  }

  public void setLogoimage(String logoimage) {
    this.logoimage = logoimage;
  }

  public String getQqopenid() {
    return qqopenid;
  }
}
