package com.example.notes;


import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CourseStorageService {
    @Autowired
    private CourseDBRepository courseDBRepository;

    public CourseDB addSubject(String subject_id, String subject_name, String courseName){
        CourseDB courseDB = new CourseDB(subject_id,subject_name, courseName);
        return courseDBRepository.save(courseDB);
    }

    public List<CourseDB> getAllSubjects()
    {
        List<CourseDB> subjects = new ArrayList<>();
        courseDBRepository.findAll().forEach(subjects::add);
        return subjects;
    }

}
