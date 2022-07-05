package Final.Project.Binar.Final.Project.Binar.Service;

import Final.Project.Binar.Final.Project.Binar.Dto.CategoryDto;
import Final.Project.Binar.Final.Project.Binar.Entity.Category;
import Final.Project.Binar.Final.Project.Binar.Entity.Product;
import Final.Project.Binar.Final.Project.Binar.Repository.CategoryRepository;
import Final.Project.Binar.Final.Project.Binar.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class CategoryService
{
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;

    public Category submitCategory (CategoryDto categoryDto) throws IOException
    {
        Category category = new Category();
//        Product product = productRepository.findById(category.getIdCategory());
//        category.getProduct();
        category.setCategoryName(categoryDto.getCategoryName());
        category.setImg(categoryDto.getImg().getBytes());
        return categoryRepository.save(category);
    }

    public List<Category> display_CategoryAll()
    {
        return categoryRepository.findAll();
    }

    public Category display_CategoryById(long Id)
    {
        return categoryRepository.findByIdCategory(Id);
    }

    public Category update_Category(long Id, CategoryDto categoryDto, MultipartFile file) throws Exception
    {
        try
        {
           Category category = categoryRepository.findByIdCategory(Id);
           Product product = productRepository.findById(categoryDto.getProduct().getIdProduct());

            if (category != null)
            {
//              category.getProduct();
              category.setCategoryName(categoryDto.getCategoryName());
              category.setImg(categoryDto.getImg().getBytes());
              return categoryRepository.save(category);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("category not found");
        }
        return null;
        }
}
