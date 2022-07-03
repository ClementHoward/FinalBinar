package Final.Project.Binar.Final.Project.Binar.Controller;

import Final.Project.Binar.Final.Project.Binar.Dto.ProductDto;
import Final.Project.Binar.Final.Project.Binar.Entity.Product;

import Final.Project.Binar.Final.Project.Binar.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("product/")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("submit")
    public ResponseEntity<?> submit(ProductDto productDto, @RequestParam("img") MultipartFile file) throws IOException
    {
        productDto.setImg(file);
        productService.submitProduck(productDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping ("display-all")
    public ResponseEntity<?> getProduct()throws Exception {
        productService.display_ProductAll();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);


//        try{
//            List<Product> display_productAll=productService.display_ProductAll();
//            return new ResponseEntity<>(display_productAll,HttpStatus.ACCEPTED);
//        }catch (Exception e)
//        {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
    }

    @GetMapping ("display/{idProduct}")
    public ResponseEntity<?> getProductById(@PathVariable ("idProduct")long Id){
        productService.display_ProductById(Id);
         return new ResponseEntity<>(HttpStatus.ACCEPTED);

//        Product response = productService.display_ProductById(Id);
//
//        if(response != null)
//        {
//            return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
//        }
//        else
//        {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
    }
    @PutMapping ("update/{idProduct}")
    public ResponseEntity<?> update_Product(@PathVariable ("idProduct") long Id,ProductDto productDto, @RequestParam("img") MultipartFile file) throws Exception
    {
        productDto.setImg(file);
        productService.update_Product(Id,productDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}