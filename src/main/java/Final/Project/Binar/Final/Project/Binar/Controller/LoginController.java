package Final.Project.Binar.Final.Project.Binar.Controller;

import Final.Project.Binar.Final.Project.Binar.Dto.UserDto;
import Final.Project.Binar.Final.Project.Binar.Entity.User;
import Final.Project.Binar.Final.Project.Binar.Service.Implementasi.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController
{
    @Autowired
    UserLoginServiceImpl userLoginServiceImpl;
    private org.springframework.web.multipart.MultipartFile MultipartFile;

    @PostMapping("/registration")
    public ResponseEntity<?> registration (@RequestBody UserDto user)
    {
        Map<String, String> map = new HashMap<>();
        User userLogin = userLoginServiceImpl.findByEmail(user.getEmail());
        if (userLogin != null)
        {
            map.put(user.getEmail(), "email already exist");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        else
        {
            userLoginServiceImpl.saveUser(user);
            return new ResponseEntity<>("registrasi buyer berhasil", HttpStatus.CREATED);
        }
//        else
//        {
//            return new ResponseEntity<>("data error", HttpStatus.METHOD_NOT_ALLOWED);
//        }
    }

    @PostMapping("/registration-seller")
    public ResponseEntity<?> registrationSeller (@RequestBody UserDto user)
    {
        Map<String, String> map = new HashMap<>();
        User userLogin = userLoginServiceImpl.findByEmail(user.getEmail());
        if (userLogin != null)
        {
            map.put(user.getEmail(), "email already exist");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        else
        {
            userLoginServiceImpl.saveSeller(user);
            return  new ResponseEntity<>("registrasi seller berhasil", HttpStatus.CREATED);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody User user)
    {
        User userLogin = userLoginServiceImpl.findByEmail(user.getEmail());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<?> login (@PathVariable long userId, UserDto userDto, @RequestParam("img") MultipartFile file) throws IOException
    {
        userLoginServiceImpl.update_user(userId, userDto);
        return new ResponseEntity<>("data user telah berhasil di-update",HttpStatus.OK);
    }
}

