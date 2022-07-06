package Final.Project.Binar.Final.Project.Binar.Service;

import Final.Project.Binar.Final.Project.Binar.Dto.CategoryDto;
import Final.Project.Binar.Final.Project.Binar.Dto.ProductDto;
import Final.Project.Binar.Final.Project.Binar.Dto.UserDto;
import Final.Project.Binar.Final.Project.Binar.Entity.Category;
import Final.Project.Binar.Final.Project.Binar.Entity.Product;
import Final.Project.Binar.Final.Project.Binar.Entity.User;
import Final.Project.Binar.Final.Project.Binar.Repository.CategoryRepository;
import Final.Project.Binar.Final.Project.Binar.Repository.ProductRepository;
import Final.Project.Binar.Final.Project.Binar.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService
{
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    UserRepository userRepository;


    public Product submitProduct(ProductDto productDto, long userid) throws IOException
    {
        Product product = new Product();
        Category category = new Category();
        User seller = userRepository.findById(userid);
        product.setCategory(categoryRepository.findById(productDto.getCategory()));

        product.setUserId(userRepository.findById(productDto.getUserid()));
        product.setStatus(productDto.getStatus());
        product.setProductName(productDto.getProductName());
        product.setKota(seller.getKota());
        product.setProvinsi(seller.getProvinsi());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImg(productDto.getImg().getBytes());

        return productRepository.save(product);
    }

    public List<Product> display_ProductAll()
    {
        return productRepository.findAll();
    }

    public Product display_ProductById(long Id)
    {
        return productRepository.findById(Id);
    }

    public void update_Product(long Id,ProductDto productDto) throws IOException
    {
       User user = userRepository.findById(Id);
       Product product = productRepository.findById(Id);
       product.setProductName(productDto.getProductName());
       product.setCategory(categoryRepository.findByIdCategory(productDto.getCategory()));
       product.setImg(productDto.getImg().getBytes());
       product.setStatus(productDto.getStatus());
       product.setKota(user.getKota());
       product.setProvinsi(user.getProvinsi());
       productRepository.save(product);


    }

}
