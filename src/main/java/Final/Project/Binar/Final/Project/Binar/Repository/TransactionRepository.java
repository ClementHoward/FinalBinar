package Final.Project.Binar.Final.Project.Binar.Repository;

import Final.Project.Binar.Final.Project.Binar.Entity.Transaction;
import Final.Project.Binar.Final.Project.Binar.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<Transaction,Long>
{
    Transaction findByIdTransaksi(long Id);
    List<Transaction> findByUserId(long userId);
    List<Transaction> findByUserPenjual(long userPenjual);

    @Modifying
    @Query(value = "UPDATE transaction SET last_updated = NOW(), status = :st WHERE id_product = :id", nativeQuery = true)
    void diterima(@Param("st") String status, @Param("id") long id);
}