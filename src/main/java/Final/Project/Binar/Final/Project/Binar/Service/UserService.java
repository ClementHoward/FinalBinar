package Final.Project.Binar.Final.Project.Binar.Service;

import Final.Project.Binar.Final.Project.Binar.Dto.UserDto;
import Final.Project.Binar.Final.Project.Binar.Entity.User;
import Final.Project.Binar.Final.Project.Binar.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User submitUser(UserDto userDto) throws IOException
    {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setProvinsi(userDto.getProvinsi());
        user.setKota(userDto.getKota());
        user.setAlamat(userDto.getAlamat());
        user.setNotelepon(userDto.getNotelepon());
        user.setImg(userDto.getImg().getBytes());
        userRepository.save(user);

        return user;
    }

    public List<User> display_userall()
    {
        return userRepository.findAll();
    }

   public User display_userid(long userId)
   {
       return userRepository.findById(userId);
   }

   public void update_user(long userId, UserDto userDto) throws IOException {
       User user = userRepository.findById(userId);

       user.setEmail(userDto.getEmail());
       user.setUsername(userDto.getUsername());
       user.setPassword(userDto.getPassword());
       user.setProvinsi(userDto.getProvinsi());
       user.setKota(userDto.getKota());
       user.setAlamat(userDto.getAlamat());
       user.setNotelepon(userDto.getNotelepon());
       user.setImg(userDto.getImg().getBytes());

       User updateUser = userRepository.save(user);
   }
}
