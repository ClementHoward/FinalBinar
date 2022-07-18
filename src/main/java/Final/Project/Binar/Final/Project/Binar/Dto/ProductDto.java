package Final.Project.Binar.Final.Project.Binar.Dto;

import Final.Project.Binar.Final.Project.Binar.Entity.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class ProductDto
{
    private long idProduct;
    private String productName;
    private BigDecimal price;
    private String status; //tersedia, ditawar, diproses, terjual
    private String description;
    private String kota;
    private MultipartFile img;
    private MultipartFile imgpenjual;
    private long category;
    private String email;
    private String username;
    private long userid;
    private String provinsi;
    private Date updated;
}
