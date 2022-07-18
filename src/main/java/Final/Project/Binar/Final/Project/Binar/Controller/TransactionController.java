package Final.Project.Binar.Final.Project.Binar.Controller;

import Final.Project.Binar.Final.Project.Binar.Dto.TransactionDto;
import Final.Project.Binar.Final.Project.Binar.Entity.Product;
import Final.Project.Binar.Final.Project.Binar.Entity.Transaction;
import Final.Project.Binar.Final.Project.Binar.Entity.User;
import Final.Project.Binar.Final.Project.Binar.Repository.TransactionRepository;
import Final.Project.Binar.Final.Project.Binar.Repository.UserRepository;
import Final.Project.Binar.Final.Project.Binar.Service.TransactionService;
import io.swagger.models.Response;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.io.IOException;

@RestController
@RequestMapping("transaction/")
public class TransactionController
{
    public Authentication authentication() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth;
    }

    @Autowired
    UserRepository userRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    TransactionService transactionService;

    @PutMapping("new/{idProduct}")
    public ResponseEntity<?> submit(@RequestBody TransactionDto transactionDto, @PathVariable("idProduct") long idProduct) throws IOException
    {
        transactionService.newTransaction(transactionDto, idProduct);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("display/{idTransaksi}")
    public ResponseEntity<?> displayById(@PathVariable("idTransaksi") long idTransaksi)
    {
        return new ResponseEntity<>(transactionService.display_TransactionById(idTransaksi), HttpStatus.ACCEPTED);
    }

    @GetMapping("display/product/{idProduct}")
    public ResponseEntity<?> displayByProduct(@PathVariable("idProduct") long idProduct)
    {
        return new ResponseEntity<>(transactionService.display_TransactionByIdProduct(idProduct), HttpStatus.ACCEPTED);
    }

    @GetMapping("display/buyer/{idUser}")
    public ResponseEntity<?> displayByBuyer(@PathVariable("idUser") long idUser)
    {
        return new ResponseEntity<>(transactionService.display_TransactionByUserId(idUser), HttpStatus.ACCEPTED);
    }

    @GetMapping("display/seller/{idSeller}")
    public ResponseEntity<?> displayBySeller(@PathVariable("idSeller") long idSeller)
    {
        return new ResponseEntity<>(transactionService.display_TransactionBySellerId(idSeller), HttpStatus.ACCEPTED);
    }

    @PutMapping("{idTransaksi}/diterima")
    public ResponseEntity<?> diterima(@PathVariable("idTransaksi") long idTransaksi) throws IOException
    {
        User userToken = userRepository.findByEmail(authentication().getPrincipal().toString());
        Transaction seller = transactionRepository.findByIdTransaksi(idTransaksi);

        if (userToken.getUserId() == seller.getUserPenjual().getUserId())
        {
            transactionService.statusDiterima(idTransaksi);
            return new ResponseEntity<>("penawaran diterima",HttpStatus.ACCEPTED);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("{idTransaksi}/ditolak")
    public ResponseEntity<?> ditolak(@PathVariable("idTransaksi") long idTransaksi) throws IOException
    {
        User userToken = userRepository.findByEmail(authentication().getPrincipal().toString());
        Transaction seller = transactionRepository.findByIdTransaksi(idTransaksi);

        if (userToken.getUserId() == seller.getUserPenjual().getUserId())
        {
            transactionService.statusDitolak(idTransaksi);
            return new ResponseEntity<>("penawaran telah ditolak",HttpStatus.ACCEPTED);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}