package Final.Project.Binar.Final.Project.Binar.Repository;

import Final.Project.Binar.Final.Project.Binar.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>
{
    Category findByIdCategory (long category);
    List<Category> findAll ();
    Category findById(long idCategory);
}
