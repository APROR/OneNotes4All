package com.example.notes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "files")
public class FileDB {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  private String name;

  private String type;

  private String[] tags;
  private Integer rating;
  private String subject_id;

  @Lob
  private byte[] data;

  public FileDB() {
  }

  public FileDB(String name, String type, byte[] data,String[] tags,String subjectId) {
    this.name = name;
    this.type = type;
    this.data = data;
    this.tags=tags;
    this.rating=0;
    this.subject_id=subjectId;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }
  public void setTags(String[] tags){
    this.tags=tags;
  }
  public void giveRating(Integer number){
    this.rating=number;
  }
  public void setType(String type) {
    this.type = type;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

  public String getSubjectId()
  {
    return subject_id;
  }

  public void setSubjectId(String subjectId)
  {
    this.subject_id = subjectId;
  }

}
