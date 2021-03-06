package za.ac.nwu.ac.domain.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT_TYPE", schema = "ACCOUNT_SYS")
public class AccountType implements Serializable {

    private Long accountTypeId;
    private String mnemonic;
    private String accountTypeName;
    private LocalDate createDate;

    private Set<AccountTransaction> accountTransactions;

    public AccountType(Long accountTypeId, String mnemonic, String accountTypeName, LocalDate createDate) {
        this.accountTypeId = accountTypeId;
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.createDate = createDate;
    }

    public AccountType() {
    }

    public AccountType(String mnemonic, String accountTypeName, LocalDate creationDate) {
        this.mnemonic = mnemonic;
        this.accountTypeName = accountTypeName;
        this.createDate = creationDate;
    }

    @Id
    @SequenceGenerator(name = "GENERIC_SEQ",sequenceName = "ACCOUNT_SYS.GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERIC_SEQ")
    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @Column(name = "MNEMONIC")
    public String getMnemonic() {
        return mnemonic;
    }

    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    @Column(name = "ACCOUNT_TYPE_NAME")
    public String getAccountTypeName() {
        return accountTypeName;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    @JsonManagedReference
    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions)
    {
        this.accountTransactions= accountTransactions;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Column(name = "CREATION_DATE")
    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, mnemonic, accountTypeName, createDate);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
