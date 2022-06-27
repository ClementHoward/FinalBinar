package Final.Project.Binar.Final.Project.Binar.Controller;

import Final.Project.Binar.Final.Project.Binar.Dto.UserDto;
import Final.Project.Binar.Final.Project.Binar.Entity.User;
import Final.Project.Binar.Final.Project.Binar.Service.Implementasi.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController
{
    @Autowired
    UserLoginServiceImpl userLoginServiceImpl;

    @PostMapping("/registration")
    public ResponseEntity<?> registration (@RequestBody UserDto user) { //new
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

}

