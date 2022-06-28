package Final.Project.Binar.Final.Project.Binar.Controller;

import Final.Project.Binar.Final.Project.Binar.Dto.ProductDto;
import Final.Project.Binar.Final.Project.Binar.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("product/")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("submit")
    public ResponseEntity<?> submit(ProductDto productDto, @RequestParam("img") MultipartFile file) throws IOException {
        productDto.setImg(file);

        return new ResponseEntity<>( HttpStatus.CREATED);
    }
}