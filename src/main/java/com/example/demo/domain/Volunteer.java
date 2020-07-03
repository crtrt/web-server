package com.example.demo.domain;

import java.sql.Timestamp;
public class Volunteer {

  private int id;
  private int ORG_ID;
  private int CLIENT_ID;
  private String name;
  private String gender;
  private String phone;
  private String id_card;
  private java.sql.Timestamp birthday;
  private java.sql.Timestamp checkin_date;
  private java.sql.Timestamp checkoutd_ate;
  private String imgset_dir;
  private String profile_photo;
  private String room_number;
  private String DESCRIPTION;
  private String ISACTIVE;
  private java.sql.Timestamp CREATED;
  private int CREATEBY;
  private java.sql.Timestamp UPDATED;
  private int UPDATEBY;
  private String REMOVE;

  public int getID() {
    return id;
  }

  public void setID(int ID) {
    this.id = id;
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

  public String getname() {
    return name;
  }

  public void setUsername(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getId_card() {
    return id_card;
  }

  public void setId_card(String id_card) {
    this.id_card = id_card;
  }

  public Timestamp getBirthday() {
    return birthday;
  }

  public void setBirthday(Timestamp birthday) {
    this.birthday = birthday;
  }

  public Timestamp getCheckin_date() {
    return checkin_date;
  }

  public void setCheckin_date(Timestamp checkin_date) {
    this.checkin_date = checkin_date;
  }

  public Timestamp getCheckoutd_ate() {
    return checkoutd_ate;
  }

  public void setCheckoutd_ate(Timestamp checkoutd_ate) {
    this.checkoutd_ate = checkoutd_ate;
  }

  public String getImgset_dir() {
    return imgset_dir;
  }

  public void setImgset_dir(String imgset_dir) {
    this.imgset_dir = imgset_dir;
  }

  public String getProfile_photo() {
    return profile_photo;
  }

  public void setProfile_photo(String profile_photo) {
    this.profile_photo = profile_photo;
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

  public int getCREATEBY() {
    return CREATEBY;
  }

  public void setCREATEBY(int CREATEBY) {
    this.CREATEBY = CREATEBY;
  }

  public Timestamp getUPDATED() {
    return UPDATED;
  }

  public void setUPDATED(Timestamp UPDATED) {
    this.UPDATED = UPDATED;
  }

  public int getUPDATEBY() {
    return UPDATEBY;
  }

  public void setUPDATEBY(int UPDATEBY) {
    this.UPDATEBY = UPDATEBY;
  }

  public String getREMOVE() {
    return REMOVE;
  }

  public void setREMOVE(String REMOVE) {
    this.REMOVE = REMOVE;
  }

}
