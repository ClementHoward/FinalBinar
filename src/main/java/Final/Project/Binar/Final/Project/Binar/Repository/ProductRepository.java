package Final.Project.Binar.Final.Project.Binar.Repository;

import Final.Project.Binar.Final.Project.Binar.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product,Long>
{
//    Repository FindByIdProduct (long idProduct);
     List<Product> findAll ();
     Product findById (long Id);
     Product findByUserId(long userId);
}
