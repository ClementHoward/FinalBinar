package Final.Project.Binar.Final.Project.Binar.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "vw_transaction")
public class Vw_Transaction
{
    @Id
    @Column(name = "id_transaksi")
    private long idTransaksi;

    @Column(name = "userid", nullable = false)
    private long userId;
    @Column(name = "imgbuyer")
    private byte[] imgbuyer;
    @Column(name = "buyerName")
    private String buyerName;
    @Column(name = "nopeBuyer")
    private long nopeBuyer;


    @Column(name = "idseller")
    private long userPenjual;
    @Column(name = "imgseller")
    private byte[] imgseller;
    @Column(name = "sellerName")
    private String sellerName;


    @Column(name = "id_product")
    private long idProduct;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "imgproduk")
    private byte[] imgproduk;
    @Column(name = "namaproduct")
    private String productName;

    @Column(name = "status")
    private String status;

    @Column(name = "tawar")
    private BigDecimal tawar;
    @Column(name = "last_updated")
    private Date updated;

}
