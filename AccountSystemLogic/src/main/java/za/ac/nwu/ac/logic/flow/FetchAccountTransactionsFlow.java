package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

import java.util.List;

public interface FetchAccountTransactionsFlow {
    List<AccountTransactionDto> getAllTransactions();

    AccountTransactionDto setTransactionAmount(Long accountTrxMember);

    AccountTransactionDto setTransactionAmountMin(Long accountTrxMemberMin);

    AccountTransactionDto setTransactionType(Long accountTransId);
}
