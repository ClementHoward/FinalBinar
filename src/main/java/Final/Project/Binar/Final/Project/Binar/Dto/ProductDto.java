package Final.Project.Binar.Final.Project.Binar.Dto;

import Final.Project.Binar.Final.Project.Binar.Entity.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
@Setter
@Getter
public class ProductDto {
    private long idProduct;
    private String productName;
    private BigDecimal price;
    private String description;
//    private String seller;
    private String kota;
    private MultipartFile img;
    private Category category;
}
