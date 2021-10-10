package za.ac.nwu.ac.logic.flow.impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionsFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;


import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountTransactionsFlowImpl implements FetchAccountTransactionsFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;

    @Autowired
    public FetchAccountTransactionsFlowImpl(AccountTransactionTranslator accountTransactionTranslator)
    {
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    //@JsonIgnore
    public List<AccountTransactionDto> getAllTransactions()
    {
        return accountTransactionTranslator.getAllTransactions();
    }

    @Override
    public AccountTransactionDto setTransactionAmount(Long accountTrxMember)
    {
        return accountTransactionTranslator.setTransactionAmount(accountTrxMember);
    }

    @Override
    public AccountTransactionDto setTransactionAmountMin(Long accountTrxMemberMin)
    {
        return accountTransactionTranslator.setTransactionAmountMin(accountTrxMemberMin);
    }

    @Override
    public AccountTransactionDto setTransactionType(Long accountTransId)
    {
        return accountTransactionTranslator.setTransactionType(accountTransId);
    }


}
