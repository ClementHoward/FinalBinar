package Final.Project.Binar.Final.Project.Binar.Controller;

import Final.Project.Binar.Final.Project.Binar.Dto.UserDto;
import Final.Project.Binar.Final.Project.Binar.Entity.User;
import Final.Project.Binar.Final.Project.Binar.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user/")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("submit")
    public ResponseEntity<User> submitUser(UserDto userDto, @RequestParam("img")MultipartFile file) throws IOException {
        userDto.setImg(file);
        userService.submitUser(userDto);
        return new ResponseEntity<User>(userService.submitUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("display/all")
    public ResponseEntity<?> getUser(){
        return new ResponseEntity<>( userService.display_userall(),HttpStatus.ACCEPTED);
    }

    @GetMapping("display/{userId}")
    public ResponseEntity<?> display_by_id(@PathVariable long userId)
    {
        User response = userService.display_userid(userId);

        if(response != null)
        {
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("update/{userId}")
    public ResponseEntity<?> update_user(@PathVariable long userId, @RequestParam("img") MultipartFile fileUpload, UserDto userDto) throws IOException
    {
        userDto.setImg(fileUpload);
        userService.update_user(userId,userDto);
        User response = userService.display_userid(userId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
