package com.example.notes;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


public class SubjectList {

    @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")

    private String subject_name;
    private String subject_id;

    public SubjectList()
    {}

    public SubjectList(String subject_name)
    {
        this.subject_name = subject_name;
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

  public void setSubjects(String subject_name)
  {
      this.subject_name = subject_name;
  }
}
