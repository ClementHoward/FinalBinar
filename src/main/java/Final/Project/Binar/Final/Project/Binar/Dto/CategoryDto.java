package Final.Project.Binar.Final.Project.Binar.Dto;

import Final.Project.Binar.Final.Project.Binar.Entity.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class CategoryDto {
    private Long idCategory;
    private String categoryName;
    private MultipartFile Img;
    private Product product;
}
