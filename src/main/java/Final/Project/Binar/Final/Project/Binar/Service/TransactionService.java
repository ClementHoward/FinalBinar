package Final.Project.Binar.Final.Project.Binar.Service;

import Final.Project.Binar.Final.Project.Binar.Dto.TransactionDto;
import Final.Project.Binar.Final.Project.Binar.Entity.*;
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
    @Autowired
    NotificationRepository notificationRepository;


    public Authentication authentication()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth;
    }

    public void newTransaction(TransactionDto transactionDto, long idProduct) throws IOException
    {
        Product product = productRepository.findById(idProduct);
        User buyer = userRepository.findByEmail(authentication().getPrincipal().toString());
        Notification notif= new Notification();
        Transaction transaction = new Transaction();

        transaction.setUserId(buyer);
        transaction.setImgbuyer(buyer.getImg());
        transaction.setBuyerName(buyer.getUsername());
        transaction.setNopeBuyer(buyer.getNotelepon());


        transaction.setUserPenjual(product.getUserId());
        transaction.setImgseller(product.getImgpenjual());
        transaction.setSellerName(product.getUsername());


        transaction.setIdProduct(product);
        transaction.setPrice(product.getPrice());
        transaction.setImgproduk(product.getImg());
        transaction.setProductName(product.getProductName());


        transaction.setStatus("ditawar");
        transaction.setTawar(transactionDto.getTawar());

        notif.setIdProduct(product);
        notif.setProductName(product.getProductName());
        notif.setUserPenjual(product.getUserId());
        notif.setStatusTransaksi(transaction.getStatus());
        notif.setTawar(transaction.getTawar());
        notif.setUserPembeli(transaction.getUserId());
        notificationRepository.save(notif);
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

    public List<Vw_Transaction> display_TransactionBySellerId(long sellerId)
    {
        return vw_transactionRepository.findByUserPenjual(sellerId);
    }

    public void statusDiterima(long Id) throws IOException
    {
        Transaction transaction = transactionRepository.findByIdTransaksi(Id);
        Product product = productRepository.findById(transaction.getIdProduct().getIdProduct());

        transactionRepository.diterima("ditolak",transaction.getIdProduct().getIdProduct());
        
        product.setStatus("terjual");
        transaction.setStatus("diterima");
        transaction.setPrice(transaction.getPrice());

//        Notification notification = notificationRepository.findByIdProduct(Id);
//        notification.setStatusTransaksi("diterima");
//        notificationRepository.save(notification);

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
