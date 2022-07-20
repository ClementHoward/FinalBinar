package Final.Project.Binar.Final.Project.Binar.Dto;


import Final.Project.Binar.Final.Project.Binar.Entity.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class TransactionDto
{
    private long idTransaksi;

    private long userId;
    private MultipartFile imgbuyer;
    private String buyerName; //new
    private long nopeBuyer; //new


    private User userPenjual;
    private MultipartFile imgseller;
    private String sellerName; //new


    private long idProduct;
    private BigDecimal price;
    private MultipartFile imgproduk;
    private String productName;


    private String status; //ditawar-diterima-ditolak

    private BigDecimal tawar;
    @CreationTimestamp
    private Date updated;
}
