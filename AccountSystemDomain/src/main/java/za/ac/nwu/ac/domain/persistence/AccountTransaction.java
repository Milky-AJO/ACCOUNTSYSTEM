package za.ac.nwu.ac.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TRX", schema = "ANDREAS")
public class AccountTransaction implements Serializable {
    @Id
    @SequenceGenerator(name = "GENERIC_SEQ",sequenceName = "ANDREAS.GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERIC_SEQ")

    @Column(name = "ACC_TRX_ID")
    private Long accountTrxId;

    @Column(name = "ACCOUNT_TYPE_ID")
    private AccountType accountType;

    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "ACC_TRX_AMOUNT")
    private Long accountTrxAmount;

    public AccountTransaction() {

    }

    public AccountTransaction(Long accountTrxId, AccountType accountType, Long memberId, Long accountTrxAmount) {
        this.accountTrxId = accountTrxId;
        this.accountType = accountType;
        this.memberId = memberId;
        this.accountTrxAmount = accountTrxAmount;
    }

    public Long getAccountTrxId() {
        return accountTrxId;
    }

    public void setAccountTrxId(Long accountTrxId) {
        this.accountTrxId = accountTrxId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getAccountTrxAmount() {
        return accountTrxAmount;
    }

    public void setAccountTrxAmount(Long accountTrxAmount) {
        this.accountTrxAmount = accountTrxAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(accountTrxId, that.accountTrxId) && Objects.equals(accountType, that.accountType) && Objects.equals(memberId, that.memberId) && Objects.equals(accountTrxAmount, that.accountTrxAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTrxId, accountType, memberId, accountTrxAmount);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "accountTrxId=" + accountTrxId +
                ", accountType=" + accountType +
                ", memberId=" + memberId +
                ", accountTrxAmount=" + accountTrxAmount +
                '}';
    }
}
