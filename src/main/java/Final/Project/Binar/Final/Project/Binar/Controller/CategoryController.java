package Final.Project.Binar.Final.Project.Binar.Controller;

import Final.Project.Binar.Final.Project.Binar.Dto.CategoryDto;
import Final.Project.Binar.Final.Project.Binar.Entity.Category;
import Final.Project.Binar.Final.Project.Binar.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("category/")
public class CategoryController
{
    @Autowired
    CategoryService categoryService;

    @PostMapping("submit")
    public ResponseEntity<?> submit(CategoryDto categoryDto, @RequestParam("img")MultipartFile file)throws Exception
    {
        categoryDto.setImg(file);
        categoryService.submitCategory(categoryDto);
        return new ResponseEntity<>("Category Berhasil Dibuat",HttpStatus.CREATED);
    }

    @GetMapping("display-all")
    public ResponseEntity<?> getAllCategory()
    {
        List<Category> response = categoryService.display_CategoryAll();
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @GetMapping("display/{idCategory}")
    public ResponseEntity<?> getCategoryById (CategoryDto categoryDto, @PathVariable("idCategory")long Id,MultipartFile file)
    {
        Category response = categoryService.display_CategoryById(Id);

        if(response != null)
        {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("category tidak ada",HttpStatus.NOT_FOUND);
        }
    }

//    @PutMapping("update/{idCategory}")
//    public ResponseEntity<?> update(@PathVariable("idCategory")long Id,CategoryDto categoryDto, @RequestParam("img")
//            MultipartFile file) throws Exception
//    {
//        categoryDto.setImg(file);
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    }
}
