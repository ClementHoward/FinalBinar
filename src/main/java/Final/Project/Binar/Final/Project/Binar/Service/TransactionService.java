package Final.Project.Binar.Final.Project.Binar.Service;

import Final.Project.Binar.Final.Project.Binar.Dto.TransactionDto;
import Final.Project.Binar.Final.Project.Binar.Entity.Product;
import Final.Project.Binar.Final.Project.Binar.Entity.Transaction;
import Final.Project.Binar.Final.Project.Binar.Entity.User;
import Final.Project.Binar.Final.Project.Binar.Entity.Vw_Transaction;
import Final.Project.Binar.Final.Project.Binar.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService
{
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    Vw_TransactionRepository vw_transactionRepository;
    @Autowired
    UserRepository userRepository;

    public Authentication authentication()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth;
    }

    public void newTransaction(TransactionDto transactionDto, long idProduct) throws IOException
    {
        Product product = productRepository.findById(idProduct);
        User buyer = userRepository.findByEmail(authentication().getPrincipal().toString());

        Transaction transaction = new Transaction();

        transaction.setUserId(buyer);

        transaction.setIdProduct(product);
        transaction.setStatus("ditawar");
        transaction.setPrice(product.getPrice());

        transaction.setTawar(transactionDto.getTawar());

        transactionRepository.save(transaction);
    }

    public Vw_Transaction display_TransactionById(long Id)
    {
        return vw_transactionRepository.findByIdTransaksi(Id);
    }

    public List<Vw_Transaction> display_TransactionByIdProduct(long idProduct)
    {
        return vw_transactionRepository.findByIdProduct(idProduct);
    }

    public List<Vw_Transaction> display_TransactionByUserId(long userId)
    {
        return vw_transactionRepository.findByUserId(userId);
    }

    public void statusDiterima(long Id) throws IOException
    {
        Transaction transaction = transactionRepository.findByIdTransaksi(Id);
        Product product = productRepository.findById(transaction.getIdProduct().getIdProduct());

        transactionRepository.diterima("ditolak",transaction.getIdProduct().getIdProduct());
        
        product.setStatus("diproses");
        transaction.setStatus("diterima");
        transaction.setPrice(transaction.getPrice());

        transactionRepository.save(transaction);
    }

    public void statusDitolak(long Id) throws IOException
    {
        Transaction transaction = transactionRepository.findByIdTransaksi(Id);
        Product product = productRepository.findById(transaction.getIdProduct().getIdProduct());

        transaction.setStatus("ditolak");
        transaction.setPrice(transaction.getPrice());

        transactionRepository.save(transaction);
    }
}
