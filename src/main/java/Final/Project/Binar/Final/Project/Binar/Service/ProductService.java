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
//    @Autowired
//    UserDto userDto;

    public Product submitProduct(ProductDto productDto) throws IOException
    {
        Product product = new Product();
        Category category = categoryRepository.findByIdCategory(productDto.getIdProduct());
//        User userid = userDto.getUserId(productDto.getIdProduct());
//        User provinsi = userDto.getProvinsi(productDto.getIdProduct());
//        User kota = userDto.getKota(productDto.getIdProduct());

//        product.getUser_id();
//        product.getProvinsi();
//        product.getKota();
        product.setCategory(category);
        product.setProductName(productDto.getProductName());
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

    public Product update_Product(long Id, ProductDto productDto) throws IOException
    {
        try
        {
            Product product = productRepository.findById(Id);
            Category category = categoryRepository.findByIdCategory(productDto.getCategory());

            if (product != null)
            {
             product.setCategory(category);
             product.setProductName(productDto.getProductName());
             product.setPrice(productDto.getPrice());
             product.setDescription(productDto.getDescription());
             product.setImg(productDto.getImg().getBytes());
                return productRepository.save(product);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("product not found");
        }
        return null;
    }

}
