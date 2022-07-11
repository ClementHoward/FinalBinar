package Final.Project.Binar.Final.Project.Binar.Controller;

import Final.Project.Binar.Final.Project.Binar.Dto.ProductDto;
import Final.Project.Binar.Final.Project.Binar.Dto.UserDto;
import Final.Project.Binar.Final.Project.Binar.Entity.Product;

import Final.Project.Binar.Final.Project.Binar.Entity.Vw_Product;
import Final.Project.Binar.Final.Project.Binar.Repository.CategoryRepository;
import Final.Project.Binar.Final.Project.Binar.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("product/")
@Transactional
public class ProductController
{
    @Autowired
    ProductService productService;

    @PostMapping("{userid}/submit")
    public ResponseEntity<?> submit(ProductDto productDto, @PathVariable ("userid") long userid, @RequestParam("img") MultipartFile file) throws IOException
    {
        productDto.setImg(file);
        productService.submitProduct(productDto, userid);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping ("display-all")
    public ResponseEntity<?> getProduct()
    {
        List<Vw_Product> response = productService.display_ProductAll();
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @GetMapping ("display/{idProduct}")
    public ResponseEntity<?> getProductById(@PathVariable ("idProduct")long Id)
    {
        Vw_Product response = productService.display_ProductById(Id);

        if(response != null)
        {
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("barang tidak ditemukan",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping ("update/{idProduct}")
    public ResponseEntity<?> update_Product(@PathVariable ("idProduct") long Id,ProductDto productDto, @RequestParam("img") MultipartFile file) throws Exception
    {
        productDto.setImg(file);
        productService.update_Product(Id,productDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}