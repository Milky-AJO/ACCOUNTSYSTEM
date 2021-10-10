package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction", description = "A dto that represents the AccountTransaction")
public class AccountTransactionDto implements Serializable {

    //private static final long serialVersionUID = -5346853206480289868L;

    private AccountType accountType;
    private Long memberId;
    private Long accountTrxAmount;
    private LocalDate accountTrxDate;

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(AccountType accountType, Long memberId, Long accountTrxAmount, LocalDate accountTrxDate) {
        this.accountType = accountType;
        this.memberId = memberId;
        this.accountTrxAmount = accountTrxAmount;
        this.accountTrxDate = accountTrxDate;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.setAccountType(accountTransaction.getAccountType());
        this.setMemberId(accountTransaction.getMemberId());
        this.setAccountTrxAmount(accountTransaction.getAccountTrxAmount());
        this.setAccountTrxDate(accountTransaction.getAccountTrxDate());
    }

    public AccountTransactionDto(int accountTransaction) {
    }

    @ApiModelProperty(position = 1,
            value = "AccountTransaction AccountType",
            name = "AccountType",
            notes = "Uniquely identifies the account type",
            dataType = "java.lang.String",
            example = "1",
            required = true)
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @ApiModelProperty(position = 2,
            value = "AccountTransaction MemberId",
            name = "MemberId",
            notes = "Uniquely identifies the account MemberId",
            dataType = "java.lang.Long",
            example = "1",
            required = true)
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @ApiModelProperty(position = 3,
            value = "AccountTransaction Amount",
            name = "Amount",
            notes = "Amount within the transaction",
            dataType = "java.lang.Long",
            example = "200",
            required = true)
    public Long getAccountTrxAmount() {
        return accountTrxAmount;
    }

    public void setAccountTrxAmount(Long accountTrxAmount) {
        this.accountTrxAmount = accountTrxAmount;
    }

    @ApiModelProperty(position = 4,
            value = "AccountType Creation Date",
            name = "CreationDate",
            notes = "Date the account type was created",
            dataType = "java.lang.LocalDate",
            example = "2021-10-09",
            allowEmptyValue = true)
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
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(accountType, that.accountType) && Objects.equals(memberId, that.memberId) && Objects.equals(accountTrxAmount, that.accountTrxAmount) && Objects.equals(accountTrxDate, that.accountTrxDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountType, memberId, accountTrxAmount, accountTrxDate);
    }

        @JsonIgnore
    public AccountTransaction getAccountTransaction() {
        return new AccountTransaction(getAccountType(), getMemberId() ,getAccountTrxAmount(), getAccountTrxDate());
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "accountType=" + accountType +
                ", memberId=" + memberId +
                ", accountTrxAmount=" + accountTrxAmount +
                ", accountTrxDate=" + accountTrxDate +
                '}';
    }
}
