package Final.Project.Binar.Final.Project.Binar.Repository;

import Final.Project.Binar.Final.Project.Binar.Entity.Vw_Product;
import Final.Project.Binar.Final.Project.Binar.Entity.Vw_Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface Vw_TransactionRepository extends JpaRepository<Vw_Transaction, Long>
{
    List<Vw_Transaction> findAll();
    Vw_Transaction findByIdTransaksi(long Id);
    List<Vw_Transaction> findByIdProduct(long idProduct);
    List<Vw_Transaction> findByUserId(long userId);
    List<Vw_Transaction> findByUserPenjual(long userPenjual);
}
