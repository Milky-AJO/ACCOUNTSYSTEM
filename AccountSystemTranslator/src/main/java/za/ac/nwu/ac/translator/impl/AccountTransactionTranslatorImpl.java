package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;


@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private final AccountTransactionRepository accountTransactionRepository;

    @Autowired
    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository)
    {
        this.accountTransactionRepository = accountTransactionRepository;
    }

    @Override
    public List<AccountTransactionDto> getAllTransactions()
    {
        List<AccountTransactionDto> accountTransactionDtos = new ArrayList<>();
        try
        {
            for (AccountTransaction accountTransaction : accountTransactionRepository.findAll())
            {
                accountTransactionDtos.add(new AccountTransactionDto(accountTransaction));
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to read from the database.", e);
        }
        return accountTransactionDtos;
    }

    @Override
    public AccountTransactionDto setTransactionAmount(Long accountTrxMember)
    {
        try{
            int accountTransaction = accountTransactionRepository.setTransactionAmount(accountTrxMember);
            return new AccountTransactionDto(accountTransaction);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to read from the database.", e);
        }
    }

    @Override
    public AccountTransactionDto setTransactionAmountMin(Long accountTrxMemberMin)
    {
        try{
            int accountTransaction = accountTransactionRepository.setTransactionAmountMin(accountTrxMemberMin);
            return new AccountTransactionDto(accountTransaction);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to read from the database.", e);
        }
    }

    @Override
    public AccountTransactionDto setTransactionType(Long accountTransId)
    {
        try{
            int accountTransaction = accountTransactionRepository.setTransactionType(accountTransId);
            return new AccountTransactionDto(accountTransaction);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to read from the database.", e);
        }
    }


}
