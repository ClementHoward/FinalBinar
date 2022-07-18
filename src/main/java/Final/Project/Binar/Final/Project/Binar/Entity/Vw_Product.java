package Final.Project.Binar.Final.Project.Binar.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

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
    @Column(name = "username")
    private String username;
    @Column(name = "provinsi")
    private String provinsi;
    @Column(name = "kota")
    private String kota;
    @Column(name = "status")
    private String status;
    @Column(name = "namaproduct")
    private String productName;
    @Column(name = "imgpenjual")
    private byte[] imgpenjual;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "description")
    private String description;
    @Lob
    private byte[] img;
    @Column(name = "last_updated")
    private Date updated;
}
