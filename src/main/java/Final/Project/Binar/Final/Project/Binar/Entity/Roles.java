package Final.Project.Binar.Final.Project.Binar.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tbl_roles")
@Setter
@Getter
@NoArgsConstructor
public class Roles
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int rolesId;

    @Column(name = "role")
    private String role;
}
