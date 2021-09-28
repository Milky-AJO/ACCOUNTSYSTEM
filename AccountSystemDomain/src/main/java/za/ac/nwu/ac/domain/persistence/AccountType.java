package za.ac.nwu.ac.domain.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUNT_TYPE", schema = "ANDREAS")
public class AccountType implements Serializable {
    @Id
    @SequenceGenerator(name)
}
