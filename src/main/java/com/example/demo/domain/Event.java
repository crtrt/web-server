package com.example.demo.domain;

import java.util.Date;
import java.sql.Blob;

public class Event{

  private int id;
  private int event_type;
  //1代表义工交互检测，2代表陌生人检测，3代表摔倒检测，4代表禁止区域入侵检测，5angry，6smile
  private Date event_date;
  private String event_location;
  private String event_desc;
  private String oldperson_name;
  private byte[] image;
  private String url;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getEvent_type() {
    return event_type;
  }

  public void setEvent_type(int event_type) {
    this.event_type = event_type;
  }

  public Date getEvent_date() {
    return event_date;
  }

  public void setEvent_date(Date event_date) {
    this.event_date = event_date;
  }

  public String getEvent_location() {
    return event_location;
  }

  public void setEvent_location(String event_location) {
    this.event_location = event_location;
  }

  public String getEvent_desc() {
    return event_desc;
  }

  public void setEvent_desc(String event_desc) {
    this.event_desc = event_desc;
  }

  public String getOldperson_name() {
    return oldperson_name;
  }

  public void setOldperson_name(String oldperson_name) {
    this.oldperson_name = oldperson_name;
  }

  public byte[] getImage() {
    return image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
