package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

import java.util.List;

public interface AccountTransactionTranslator {
    List<AccountTransactionDto> getAllTransactions();

    AccountTransactionDto setTransactionAmount(Long accountTrxMember);

    AccountTransactionDto setTransactionAmountMin(Long accountTrxMemberMin);

    AccountTransactionDto setTransactionType(Long accountTransId);
}
