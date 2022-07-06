package Final.Project.Binar.Final.Project.Binar.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Product")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private long idProduct;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcategory", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private User userId;
    @JoinColumn(name = "provinsi", nullable = true)
    private String provinsi;
    @JoinColumn(name = "kota", nullable = true)
    private String kota;

    @Column(name = "status")
    private String status;

    @Column(name = "namaproduct")
    private String productName;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Lob
    private byte[] img;

}
