package com.example.notes;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.notes.FileStorageService;

@Controller
public class FileUploadController {

  @Autowired
  private FileStorageService storageService;

  @PostMapping("/upload")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("tags") String[] tags,@RequestParam("subjectId") String subjectId) {
    String message = "";
    try {
      storageService.store(file,tags,subjectId);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }

  @GetMapping("/files/{id}")
  public ResponseEntity<byte[]> getFileById(@PathVariable String id) {
    FileDB fileDB = storageService.getFile(id);

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(fileDB.getData());
  }

  @PostMapping("/rate/file")
  public ResponseEntity<ResponseMessage> rateFile(@RequestParam("ID") String ID,@RequestParam("number") Integer number){
    FileDB updatedFile=storageService.giveRate(ID, number);
    return ResponseEntity.ok().body(new ResponseMessage(updatedFile.toString()));
  }

  @GetMapping("/subject/files")
  public ResponseEntity<List<FileDB>> getFile(@RequestParam("subject_id") String id) {
    List<FileDB> fileDB = storageService.getAllSubjects(id);
    System.out.println("hello"+id);
    return ResponseEntity.ok().body(fileDB);
  }
}

