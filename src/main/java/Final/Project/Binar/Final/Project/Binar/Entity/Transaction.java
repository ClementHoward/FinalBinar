//package Final.Project.Binar.Final.Project.Binar.Entity;//package Final.Project.Binar.Final.Project.Binar.Entity;
////
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.CreationTimestamp;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.util.Date;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "Transaction")
//
//public class Transaction
//{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_transaksi")
//    private long idProduct;
//
//    @Column(name = "user_id") //manytoone
//    private long user_id;
//
//    @Column(name = "product_id") //manytoone
//    private long product_id;
//
//    @Column(name = "status")
//    private String status;
//
//    @Column(name = "harga")
//    private BigDecimal harga;
//
//    @Column(name = "tawar")
//    private BigDecimal tawar;
//
//    @CreationTimestamp
//    @Column(name = "jam dibuat")
//    private Date created;
//
//    @CreationTimestamp
//    @Column(name = "jam update")
//    private Date updated;
//}