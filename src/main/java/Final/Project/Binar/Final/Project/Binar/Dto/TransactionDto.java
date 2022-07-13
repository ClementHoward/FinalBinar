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
    private long idTransaksi;

    private long userId;

    private long idProduct;
    private BigDecimal price;

    private String status; //ditawar-diterima-ditolak

    private BigDecimal tawar;
    @CreationTimestamp
    private Date updated;
}
