package za.ac.nwu.ac.domain.persistence;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TRX", schema = "ACCOUNT_SYS")
public class AccountTransaction implements Serializable {

    private Long accountTrxId;
    private AccountType accountType;
    private Long memberId;
    private Long accountTrxAmount;
    private LocalDate accountTrxDate;


    public AccountTransaction() {

    }

    public AccountTransaction(Long accountTrxId, AccountType accountType, Long memberId, Long accountTrxAmount, LocalDate accountTrxDate) {
        this.accountTrxId = accountTrxId;
        this.accountType = accountType;
        this.memberId = memberId;
        this.accountTrxAmount = accountTrxAmount;
        this.accountTrxDate = accountTrxDate;
    }

    public AccountTransaction(AccountType accountType, Long memberId, Long accountTrxAmount, LocalDate accountTrxDate) {
        this.accountType = accountType;
        this.memberId = memberId;
        this.accountTrxAmount = accountTrxAmount;
        this.accountTrxDate = accountTrxDate;
    }


    @Id
    @SequenceGenerator(name = "GENERIC_SEQ",sequenceName = "ACCOUNT_SYS.GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERIC_SEQ")
    @Column(name = "ACC_TRX_ID")
    public Long getAccountTrxId() {
        return accountTrxId;
    }

    public void setAccountTrxId(Long accountTrxId) {
        this.accountTrxId = accountTrxId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    @JsonBackReference
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Column(name = "MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Column(name = "ACC_TRX_AMOUNT")
    public Long getAccountTrxAmount() {
        return accountTrxAmount;
    }

    public void setAccountTrxAmount(Long accountTrxAmount) {
        this.accountTrxAmount = accountTrxAmount;
    }

    @Column(name = "ACC_TRX_DATE")
    public LocalDate getAccountTrxDate() {
        return accountTrxDate;
    }

    public void setAccountTrxDate(LocalDate accountTrxDate) {
        this.accountTrxDate = accountTrxDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(accountTrxId, that.accountTrxId) && Objects.equals(accountType, that.accountType) && Objects.equals(memberId, that.memberId) && Objects.equals(accountTrxAmount, that.accountTrxAmount) && Objects.equals(accountTrxDate, that.accountTrxDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTrxId, accountType, memberId, accountTrxAmount, accountTrxDate);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "accountTrxId=" + accountTrxId +
                ", accountType=" + accountType +
                ", memberId=" + memberId +
                ", accountTrxAmount=" + accountTrxAmount +
                ", accountTrxDate=" + accountTrxDate +
                '}';
    }
}
