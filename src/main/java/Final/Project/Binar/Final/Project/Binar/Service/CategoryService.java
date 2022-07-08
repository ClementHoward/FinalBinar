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

import javax.transaction.Transactional;
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

    public Boolean update_Category(long Id, CategoryDto categoryDto) throws Exception
    {
        if(categoryRepository.existsById(Id)){
            Category category = categoryRepository.findByIdCategory(Id);
            category.setImg(categoryDto.getImg().getBytes());
            category.setCategoryName(categoryDto.getCategoryName());
            categoryRepository.save(category);
            return true;

        }else {
         return false;
        }
    }
}
