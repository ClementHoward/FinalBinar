package Final.Project.Binar.Final.Project.Binar.Controller;

import Final.Project.Binar.Final.Project.Binar.Dto.UserDto;
import Final.Project.Binar.Final.Project.Binar.Entity.User;
import Final.Project.Binar.Final.Project.Binar.Service.Implementasi.UserLoginServiceImpl;
import Final.Project.Binar.Final.Project.Binar.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("user/")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserLoginServiceImpl userLoginService;
    @PostMapping("submit")
    public ResponseEntity<User> submitUser(UserDto userDto, @RequestParam("img")MultipartFile file) throws IOException
    {
        userDto.setImg(file);
        userService.submitUser(userDto);
        return new ResponseEntity<User>(userService.submitUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("display/all")
    public ResponseEntity<?> getUser()
    {
        return new ResponseEntity<>(userService.display_userall(),HttpStatus.ACCEPTED);
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

    @PutMapping("update/{userid}")
    public ResponseEntity<?> update_user(@PathVariable("userid") long userid, @RequestParam("img") MultipartFile fileUpload, UserDto userDto) throws IOException
    {
        userDto.setImg(fileUpload);
        userLoginService.update_user(userid,userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
