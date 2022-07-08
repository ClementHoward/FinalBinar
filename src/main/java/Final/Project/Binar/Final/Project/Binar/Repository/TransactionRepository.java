package Final.Project.Binar.Final.Project.Binar.Repository;

import Final.Project.Binar.Final.Project.Binar.Entity.Transaction;
import Final.Project.Binar.Final.Project.Binar.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<Transaction,Long>
{
    Transaction findByIdTransaksi(long Id);
//    List<Transaction> findByIdUser(long userId);
}