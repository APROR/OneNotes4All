package com.example.notes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class CourseUploadController{

@Autowired
private CourseStorageService courseStorageService;

@PostMapping("/subjects/add")
public ResponseEntity<ResponseMessage> addCourse(@RequestBody CourseDB course) {
    String msg ="";
    try{
         courseStorageService.addSubject(course.getSubject_id(),course.getSubject_name(), course.getCourse_name());
          msg = "Course Added Successfully";
          return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(course.toString()));
    }catch (Exception e) {
        msg = "Could not add Course!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(e.toString()));
      }
}
protected CourseDB mapCourseData(CourseDB Course) {
    CourseDB course = new CourseDB(Course.getSubject_id(),Course.getSubject_name(), Course.getCourse_name());
    return course;
   }
   @GetMapping("/subjects")
   public ResponseEntity<List<CourseDB>> getFile() {
     List<CourseDB> allSubjects = courseStorageService.getAllSubjects();
     return ResponseEntity.ok()
         .body(allSubjects);
   }

}
