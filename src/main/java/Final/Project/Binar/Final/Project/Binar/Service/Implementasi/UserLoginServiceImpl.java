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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserLoginServiceImpl implements UserLoginService, UserDetailsService
{

    @Autowired
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

    public User saveUser(UserDto userLogin)
    {
        User saveUser = new User();
        saveUser.setUsername(userLogin.getUsername());
        saveUser.setEmail(userLogin.getEmail());
        List<Roles> getRoleById = roleRepository.findByRolesId(1);
        saveUser.setRoles(getRoleById);
        saveUser.setPassword(passwordEncoder.encode(userLogin.getPassword()));
        return userRepository.save(saveUser);
    }

    public User update_user(String email, UserDto userDto)
    {
        try {
            User user = userRepository.findByEmail(email);
            if (user != null)
            {
                user.setUsername(userDto.getUsername());
//                user.setEmail(userDto.getEmail());
//                user.setPassword(passwordEncoder.encode(userDto.getPassword()));
                user.setKota(userDto.getKota());
                user.setProvinsi(userDto.getProvinsi());
                user.setAlamat(userDto.getAlamat());
                user.setNotelepon(userDto.getNotelepon());
                user.setImg(userDto.getImg().getBytes());
                return userRepository.save(user);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("user not found");
        }
        return null;
    }

    public User display_by_id(long user_id)
    {
        return userRepository.findById(user_id);
    }

    public User display_by_email(String email, UserDto userDto)
    {
        return userRepository.findByEmail(email);
    }

    @Override
    public User saveSeller(UserDto userLogin)
    {
        User saveUser = new User();
        saveUser.setUsername(userLogin.getUsername());
        saveUser.setEmail(userLogin.getEmail());
        List<Roles> getRoleById = roleRepository.findByRolesId(2);
        saveUser.setRoles(getRoleById);
        saveUser.setPassword(passwordEncoder.encode(userLogin.getPassword()));
        return userRepository.save(saveUser);
    }

//    public List<User> update_seller(long userId, UserDto userDto, MultipartFile file)
//    {
//        try
//        {
//            User user = userRepository.findById(userId);
//            if (user != null)
//            {
//                user.setUsername(userDto.getUsername());
//                user.setEmail(userDto.getEmail()); //user gabisa ganti email
//                user.setKota(userDto.getKota());
//                user.setProvinsi(userDto.getProvinsi());
//                user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//                user.setAlamat(userDto.getAlamat());
//                user.setNotelepon(userDto.getNotelepon());
//                user.setImg(userDto.getImg().getBytes());
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
}