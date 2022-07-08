package Final.Project.Binar.Final.Project.Binar.Controller;

import Final.Project.Binar.Final.Project.Binar.Dto.TransactionDto;
import Final.Project.Binar.Final.Project.Binar.Service.TransactionService;
import io.swagger.models.Response;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("transaction/")
public class TransactionController
{
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

    @GetMapping("display/seller/{idSeller}")
    public ResponseEntity<?> displayBySeller(@PathVariable("idSeller") long idSeller)
    {
        return new ResponseEntity<>(transactionService.display_TransactionByUserId(idSeller), HttpStatus.ACCEPTED);
    }

    @PutMapping("{idTransaksi}/diterima")
    public ResponseEntity<?> diterima(@PathVariable("idTransaksi") long idTransaksi) throws IOException
    {
        transactionService.statusDiterima(idTransaksi);
        return new ResponseEntity<>("penawaran diterima",HttpStatus.ACCEPTED);
    }

    @PutMapping("{idTransaksi}/ditolak")
    public ResponseEntity<?> ditolak(@PathVariable("idTransaksi") long idTransaksi) throws IOException
    {
        transactionService.statusDitolak(idTransaksi);
        return new ResponseEntity<>("penawaran telah ditolak",HttpStatus.ACCEPTED);
    }
}