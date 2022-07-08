package Final.Project.Binar.Final.Project.Binar.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Transaction")
public class Transaction
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaksi")
    private long idTransaksi;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_product")
    private Product idProduct;
    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "status") //ditawar,diterima,ditolak
    private String status;
    @Column(name = "tawar")
    private BigDecimal tawar;
    @CreationTimestamp
    @Column(name = "last_updated")
    private Date updated;
}