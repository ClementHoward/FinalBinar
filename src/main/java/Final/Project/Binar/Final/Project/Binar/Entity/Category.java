package Final.Project.Binar.Final.Project.Binar.Entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "Category")
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategory")
    private long idCategory;
    @Column(name ="category")
    private String categoryName;
    @Lob
    private byte[] img;

}
