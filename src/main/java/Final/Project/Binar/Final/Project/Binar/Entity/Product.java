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
    @Column(name = "id_product")
    private long idProduct;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user_id;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "provinsi", nullable = false)
//    private User provinsi;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "kota", nullable = false)
//    private User kota;

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
