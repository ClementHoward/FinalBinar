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
    @Column(name = "id_product")
    private long idProduct;
    @Column(name = "status")
    private String status;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "tawar")
    private BigDecimal tawar;
    @Column(name = "last_updated")
    private Date updated;
    @Column(name = "idseller")
    private long userPenjual;
}
