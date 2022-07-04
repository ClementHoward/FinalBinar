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

    @GetMapping("/profile")
    public ResponseEntity<?> profile (UserDto userDto) throws IOException
    {
        User userToken = userRepository.findByEmail(authentication().getPrincipal().toString());
        User display = userLoginServiceImpl.display_by_email(userToken.getEmail(), userDto);
        {
            if (userToken.getEmail().equalsIgnoreCase(authentication().getPrincipal().toString()))
            {
                return new ResponseEntity<>(display, HttpStatus.ACCEPTED);
            }
            else
            {
                return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
            }
        }
    }


    @PutMapping("/update")
    public ResponseEntity<?> update_user (UserDto userDto, @RequestParam("img") MultipartFile file) throws IOException
    {
        User user = userLoginServiceImpl.findByEmail(userDto.getEmail());
        User userToken = userRepository.findByEmail(authentication().getPrincipal().toString());
        {
            if (userToken.getEmail().equalsIgnoreCase(authentication().getPrincipal().toString()))
            {
                userLoginServiceImpl.update_user(userToken.getEmail(), userDto);
                return new ResponseEntity<>("update akun berhasil", HttpStatus.ACCEPTED);
            }
            else
            {
                return new ResponseEntity<>("kode auth salah",HttpStatus.BAD_GATEWAY);
            }
        }
    }
}