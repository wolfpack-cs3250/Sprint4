package com.banner.bannerApplication.ExtraStuff;

import com.banner.bannerApplication.entities.Professor;
import com.banner.bannerApplication.entities.User;
import com.banner.bannerApplication.repositories.ProfessorRepository;
import com.banner.bannerApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfessorRepository professorRepository;
public User findUser(Long id){
    return userRepository.findOne(id);
}

public User findUser(String name){
    return  userRepository.findByFirstName(name);
    //might be spagetti
}

public Professor findProfessor(Long id){
    return professorRepository.findOne(id);
}
public  Professor findProfessor(String name){
    return professorRepository.findByLastName(name);
}
public User loginUser(String userId,String password){
    User user= this.findUser(userId);
    if(user!=null&& user.getPassword().equals(password)){
        return user;
    }
    return null;
}
public Professor loginProfessor(String userId, String password){
    Professor professor= this.findProfessor(userId);
    if(professor!=null && professor.getPassword().equals(password)){
        return professor;
    }
    return null;
}
}
