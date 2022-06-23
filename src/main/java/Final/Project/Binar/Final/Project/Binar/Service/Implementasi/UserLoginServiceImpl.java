package Final.Project.Binar.Final.Project.Binar.Service.Implementasi;

import Final.Project.Binar.Final.Project.Binar.Dto.UserDto;
import Final.Project.Binar.Final.Project.Binar.Entity.Roles;
import Final.Project.Binar.Final.Project.Binar.Entity.User;
import Final.Project.Binar.Final.Project.Binar.Repository.RoleRepository;
import Final.Project.Binar.Final.Project.Binar.Repository.UserRepository;
import Final.Project.Binar.Final.Project.Binar.Service.UserLoginService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserLoginService, UserDetailsService
{

    private final UserRepository userRepository;
    @Autowired
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    public final Logger logger = LogManager.getLogger(UserLoginService.class);
    //create role Repo dengan method abstract findByIdRole

    @Override
    public User findByEmail(String email)
    {
        return  userRepository.findByEmail(email);
    }

    @Override
    public User saveUser(UserDto user) {
        User saveUser = new User();
        saveUser.setUsername(saveUser.getUsername());
        saveUser.setEmail(saveUser.getEmail());
        List<Roles> getRoleById = roleRepository.findByRolesId(1);
        saveUser.setRoles(getRoleById);
        saveUser.setPassword(passwordEncoder.encode(saveUser.getPassword()));
        return userRepository.save(saveUser);
    }

    @Override
    public User saveSeller(UserDto user) {
        User saveUser = new User();
        saveUser.setUsername(saveUser.getUsername());
        saveUser.setEmail(saveUser.getEmail());
        List<Roles> getRoleById = roleRepository.findByRolesId(2);
        saveUser.setRoles(getRoleById);
        saveUser.setPassword(passwordEncoder.encode(saveUser.getPassword()));
        return userRepository.save(saveUser);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        User user = userRepository.findByEmail(email);
        if (user == null)
        {
            logger.error("user not found");
        }
        else
        {
            logger.info(email + "user found");
        }
        Collection<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        user.getRoles().forEach(role -> simpleGrantedAuthorities
                .add(new SimpleGrantedAuthority(role.getRole())));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), simpleGrantedAuthorities);
    }

////    @Override
////    public User saveUser(UserDto userLogin)
////    {
////        User saveUser = new User();
////        saveUser.setUsername(userLogin.getUsername());
////        saveUser.setEmail(userLogin.getEmail());
////        List<Roles> getRoleById = roleRepository.findByRolesId(1);
////        saveUser.setRoles(getRoleById);
////        saveUser.setPassword(passwordEncoder.encode(userLogin.getPassword()));
////        return userRepository.save(saveUser);
////    }
//
//
//    public List<User> update_user(long userId, UserDto userDto, MultipartFile file)
//    {
//        try {
//            User user = userRepository.findById(userId);
//            if (user != null)
//            {
//                user.setUsername(userDto.getUsername());
//                user.setEmail(userDto.getEmail());
//                user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//                user.setAlamat(userDto.getAlamat());
//                user.setNotelepon(userDto.getNotelepon());
//                user.setImg(file.getBytes());
//                User userupdate = userRepository.save(user);
//            }
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            System.out.println("user not found");
//        }
//        return null;
//    }
//
//    public Optional<User> display_by_id(Long user_id)
//    {
//        return userRepository.findById(user_id);
//    }
//
//
//    @Override
//    public User saveSeller(UserDto userLogin)
//    {
//        User saveUser = new User();
//        saveUser.setUsername(userLogin.getUsername());
//        saveUser.setEmail(userLogin.getEmail());
//        List<Roles> getRoleById = roleRepository.findByRolesId(2);
//        saveUser.setRoles(getRoleById);
//        saveUser.setPassword(passwordEncoder.encode(userLogin.getPassword()));
//        return userRepository.save(saveUser);
//    }
}