package Final.Project.Binar.Final.Project.Binar.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
@Getter
@Setter
@Entity
@Table(name = "vw_product")
public class Vw_Product
{
    @Id
    @Column(name = "id_product")
    private long idProduct;
    @Column(name = "idcategory", nullable = false)
    private long category;
    @Column(name = "userid", nullable = false)
    private long userId;
    @Column(name = "provinsi")
    private String provinsi;
    @Column(name = "kota")
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
