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
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notification")
    private long idNotification;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_product", nullable = false)
    private Product idProduct;
    @Column(name = "namaproduct")
    private String productName;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idpenjual")
    private User userPenjual;

    @Column(name = "status_transaksi")
    private String statusTransaksi;
    @Column (name = "tawar")
    private BigDecimal tawar;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name= "idpembeli")
    private User userPembeli;
    @CreationTimestamp
    @Column(name = "jam_notifikasi")
    private Date jam;


}
