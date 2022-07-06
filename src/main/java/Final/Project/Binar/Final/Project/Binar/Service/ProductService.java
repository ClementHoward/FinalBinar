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
        product.setKota(productDto.getKota());
        product.setProvinsi(productDto.getProvinsi());
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

//    public Product update_Product(long Id,ProductDto productDto) throws IOException
//    {
//        try
//        {
//            Product product = productRepository.findById(Id);
//            Category category = categoryRepository.findByIdCategory(productDto.getCategory());
//
//            if (product != null)
//            {
//                product.setStatus(productDto.getStatus());
//
//                product.setCategory(category);
//                product.setProductName(productDto.getProductName());
//                product.setPrice(productDto.getPrice());
//                product.setDescription(productDto.getDescription());
//                product.setImg(productDto.getImg().getBytes());
//                return productRepository.save(product);
//            }
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            System.out.println("product not found");
//        }
//        return null;
//    }

}
