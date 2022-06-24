package Final.Project.Binar.Final.Project.Binar.Service;

import Final.Project.Binar.Final.Project.Binar.Dto.ProductDto;
import Final.Project.Binar.Final.Project.Binar.Entity.Category;
import Final.Project.Binar.Final.Project.Binar.Entity.Product;
import Final.Project.Binar.Final.Project.Binar.Repository.CategoryRepository;
import Final.Project.Binar.Final.Project.Binar.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public Product submitProduck(ProductDto productDto) {
    Product product = new Product();
    Category category = categoryRepository.findByIdCategory(productDto.getIdProduct());
    product.setCategory(category);
    product.setProductName(productDto.getProductName());
    product.setPrice(productDto.getPrice());
    product.setDescription(productDto.getDescription());
    product.setSeller(productDto.getSeller());
    product.setKota(productDto.getKota());
    product.setImg(productDto.getImg());
    return productRepository.save(product);
    }

}
