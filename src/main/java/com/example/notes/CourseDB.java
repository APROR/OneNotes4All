package com.example.notes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "subject_table")

public class CourseDB {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  
  private String id;
  private String subject_name;
  private String subject_id;
  private String course_name;

  public CourseDB()
  {
  }

  public CourseDB(String subject_id, String subject_name, String course_name)
  {
      this.subject_id = subject_id;
      this.subject_name= subject_name;
      this.course_name = course_name;
      
  }


  public String getId()
  {
      return id;
  }

  public void setId(String id)
  {
      this.id = id;
  }

  public String getSubject_id()
  {
      return subject_id;
  }

  public void setSubject_id(String subject_id)
  {
      this.subject_id = subject_id;
  }

  public String getSubject_name()
  {
      return subject_name;
  }

  public void setSubject_name(String subject_name)
  {
      this.subject_name = subject_name;
  }

  public String getCourse_name()
  {
      return course_name;
  }

  public void setCourse_name(String course_name)
  {
      this.course_name = course_name;
  }

}
