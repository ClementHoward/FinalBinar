package Final.Project.Binar.Final.Project.Binar.Repository;

import Final.Project.Binar.Final.Project.Binar.Entity.Vw_Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface Vw_ProductRepository extends JpaRepository<Vw_Product, Long> {

    List<Vw_Product> findAll();
    Vw_Product findByIdProduct (long idProduct);
}
