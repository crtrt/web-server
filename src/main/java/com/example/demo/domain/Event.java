package com.example.demo.domain;


import java.sql.Timestamp;

public class Event {

  private int id;
  private int event_type;
  private java.sql.Timestamp event_date;
  private String event_location;
  private String event_desc;
  private int oldperson_id;

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

  public Timestamp getEvent_date() {
    return event_date;
  }

  public void setEvent_date(Timestamp event_date) {
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

  public int getOldperson_id() {
    return oldperson_id;
  }

  public void setOldperson_id(int oldperson_id) {
    this.oldperson_id = oldperson_id;
  }
}
