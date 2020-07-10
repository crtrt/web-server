package com.example.demo.domain;

//import java.sql.Blob;

public class EventImage {

  private int id;
  private String type;
  private byte[] image;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public byte[] getImage() {
    return image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }
}
