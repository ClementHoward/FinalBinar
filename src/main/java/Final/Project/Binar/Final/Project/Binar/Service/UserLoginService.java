package Final.Project.Binar.Final.Project.Binar.Service;

import Final.Project.Binar.Final.Project.Binar.Dto.UserDto;
import Final.Project.Binar.Final.Project.Binar.Entity.User;


public interface UserLoginService {
    public User findByEmail (String username);
    public User saveUser (UserDto user); // new
    public User saveSeller (UserDto user);
}

