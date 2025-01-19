package com.example.anshika.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.anshika.Entity.User;
import com.example.anshika.Service.CreateUserService;
import com.example.anshika.Service.ValidateLoginService;

@RestController
@CrossOrigin
@RequestMapping("/start")
public class SignUpController {

    @Autowired
    private CreateUserService createUserService;

    @Autowired
    private ValidateLoginService validateLoginService;

    @GetMapping("/test")
    public String test(){
        return "Hello World";
    }

    @PostMapping("/signup")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        User savedUser = createUserService.saveUser(user);
        System.out.println("Created New User -> "+ savedUser);

        if (savedUser!=null){
            System.out.println("User created -> "+ savedUser);
            
            return new ResponseEntity<>("Signup Successfull", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("SignUp Failed!!, TRY AGAIN", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
    if(user.getUserid() == null || user.getPassword() == null) {
        return new ResponseEntity<>("User id or password cannot be null", HttpStatus.BAD_REQUEST);
    }
    Optional<User> optional = validateLoginService.validateLogin(user);
    if(optional.isPresent()) {
        User user2 = optional.get();
        if(user2.getPassword().equals(user.getPassword())) {
            System.out.println("LogIn Successful ::"+user2.getUserid());
            return new ResponseEntity<>("LogIn Successfull", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Incorrect Password", HttpStatus.UNAUTHORIZED);
        }
    }
    else {
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
}

}