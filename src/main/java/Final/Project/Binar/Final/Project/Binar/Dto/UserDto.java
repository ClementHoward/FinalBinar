package Final.Project.Binar.Final.Project.Binar.Dto;

import Final.Project.Binar.Final.Project.Binar.Entity.Roles;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class UserDto
{
    private long userId;
    private String email;
    private String username;
    private String password;
    private String provinsi;
    private String kota;
    private String alamat;
    private long notelepon;
    private List<Roles> roles;
    private MultipartFile img;
    private int roleId;
}
