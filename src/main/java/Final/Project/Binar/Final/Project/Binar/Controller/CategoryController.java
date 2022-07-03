package Final.Project.Binar.Final.Project.Binar.Controller;

import Final.Project.Binar.Final.Project.Binar.Dto.CategoryDto;
import Final.Project.Binar.Final.Project.Binar.Entity.Category;
import Final.Project.Binar.Final.Project.Binar.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("category/")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("submit")
    public ResponseEntity<?> submit(CategoryDto categoryDto, @RequestParam("img")MultipartFile file)throws Exception{
        categoryDto.setImg(file);
        categoryService.submitCategory(categoryDto);
        return new ResponseEntity<>("Category Berhasil Dibuat",HttpStatus.CREATED);
    }
    @GetMapping("display-all")
    public ResponseEntity<?> getAllCategory(CategoryDto CategoryDto){

        categoryService.display_CategoryAll(CategoryDto);
        return new ResponseEntity<Category>(HttpStatus.ACCEPTED);
    }
    @GetMapping("display/{idCategory}")
    public ResponseEntity<?> getCategoryById (CategoryDto categoryDto, @PathVariable("idCategory")long Id,MultipartFile file){
        categoryService.display_CategoryById(Id);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }
    @PutMapping("update/{idCategory}")
    public ResponseEntity<?> update(@PathVariable("idCategory")long Id,CategoryDto categoryDto, @RequestParam("img")
            MultipartFile file) throws Exception{
        categoryDto.setImg(file);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
