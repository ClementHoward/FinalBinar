package Final.Project.Binar.Final.Project.Binar.Controller;

import Final.Project.Binar.Final.Project.Binar.Dto.UserDto;
import Final.Project.Binar.Final.Project.Binar.Entity.User;
import Final.Project.Binar.Final.Project.Binar.Repository.UserRepository;
import Final.Project.Binar.Final.Project.Binar.Service.Implementasi.UserLoginServiceImpl;
import Final.Project.Binar.Final.Project.Binar.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



@RestController
public class LoginController
{
    public Authentication authentication()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth;
    }

    @Autowired
    UserRepository userRepository;

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
    public ResponseEntity<?> update_user (@PathVariable long userId, UserDto userDto, @RequestParam("img") MultipartFile file) throws IOException
    {
        User user = userLoginServiceImpl.findByEmail(userDto.getEmail());
        User userToken = userRepository.findById(userId);
        if (user != null)
        {
            return new ResponseEntity<>("Error User", HttpStatus.BAD_REQUEST);
        }
        else
        {
            if (userToken.getEmail().equalsIgnoreCase(authentication().getPrincipal().toString()))
            {
//                user.setImg(userDto.getImg().getBytes());
                userLoginServiceImpl.update_user(userId, userDto);
                userLoginServiceImpl.display_by_id(userId);
                return new ResponseEntity<>("update akun berhasil", HttpStatus.ACCEPTED);
            }
            else
            {
                return new ResponseEntity<>("authentication error",HttpStatus.BAD_GATEWAY);
            }
        }
    }
}