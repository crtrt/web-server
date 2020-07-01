package com.example.demo.domain;


public class Event {

  private long id;
  private long eventType;
  private java.sql.Timestamp eventDate;
  private String eventLocation;
  private String eventDesc;
  private long oldpersonId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getEventType() {
    return eventType;
  }

  public void setEventType(long eventType) {
    this.eventType = eventType;
  }


  public java.sql.Timestamp getEventDate() {
    return eventDate;
  }

  public void setEventDate(java.sql.Timestamp eventDate) {
    this.eventDate = eventDate;
  }


  public String getEventLocation() {
    return eventLocation;
  }

  public void setEventLocation(String eventLocation) {
    this.eventLocation = eventLocation;
  }


  public String getEventDesc() {
    return eventDesc;
  }

  public void setEventDesc(String eventDesc) {
    this.eventDesc = eventDesc;
  }


  public long getOldpersonId() {
    return oldpersonId;
  }

  public void setOldpersonId(long oldpersonId) {
    this.oldpersonId = oldpersonId;
  }

}
