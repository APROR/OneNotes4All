package com.example.notes;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@RestController  
public class Test   
{  
@Autowired
private UserRepository userRepository;

@PostMapping(path="/add") // Map ONLY POST Requests
public @ResponseBody String addNewUser (@RequestParam String name
    , @RequestParam String email) {

  User n = new User();
  n.setName(name);
  n.setEmail(email);
  userRepository.save(n);
  return "Saved";
}  
}  