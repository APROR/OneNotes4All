package com.example.notes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileStorageService {
    @Autowired
    private FileDBRepository fileDBRepository;
  
    public FileDB store(MultipartFile file,String[] tags,String subjectId) throws IOException {
      String fileName = StringUtils.cleanPath(file.getOriginalFilename());
      FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes(),tags,subjectId);
  
      return fileDBRepository.save(FileDB);
    }
  
    public FileDB getFile(String id) {
      return fileDBRepository.findById(id).get();
    }
    public FileDB giveRate(String id,Integer number){
      Optional<FileDB> fileExists=fileDBRepository.findById(id);
      FileDB file=fileExists.get();
      file.giveRating(5);
      return fileDBRepository.save(file);
    }
    // public Iterable getAllFiles() {
    //   return fileDBRepository.findAll();
    // }

    public List<FileDB> getAllSubjects(String subject_id)
    {
        ArrayList<FileDB> subjects = new ArrayList<>();
        fileDBRepository.findAll().forEach(subjects::add);
        ArrayList<FileDB> finalSubject = new ArrayList<>();
        for(int i=0; i<subjects.size(); i++)
        {
          System.out.println(subjects.get(i).getSubjectId()+" "+subject_id);
          if(subjects.get(i).getSubjectId() == subject_id)
          {
              finalSubject.add(subjects.get(i));
          }
        }

        return subjects;
    }
}
