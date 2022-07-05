package Final.Project.Binar.Final.Project.Binar.Dto;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class TransactionDto
{
    private long idProduct;
    private long user_id;
    private long product_id;
    private String status;
    private BigDecimal harga;
    private BigDecimal tawar;

    @CreationTimestamp
    private Date created;
    @CreationTimestamp
    private Date updated;
}
