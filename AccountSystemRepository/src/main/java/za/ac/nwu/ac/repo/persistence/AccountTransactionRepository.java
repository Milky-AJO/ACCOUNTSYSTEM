package za.ac.nwu.ac.repo.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

    @Modifying
    @Query(value = "UPDATE AccountTransaction SET accountTrxAmount = accountTrxAmount + 200  WHERE memberId = :accountTrxMember")
    //int setTransactionAmount(Long accountTrxAmount, Long accountTrxMember);
    int setTransactionAmount(Long accountTrxMember);

    @Modifying
    @Query(value = "UPDATE AccountTransaction SET accountTrxAmount = accountTrxAmount - 200  WHERE memberId = :accountTrxMemberMin")
    int setTransactionAmountMin(Long accountTrxMemberMin);

    @Modifying
    @Query(value = "UPDATE AccountTransaction SET accountType = 1  WHERE accountTrxId = :accountTransId")
    int setTransactionType(Long accountTransId);

}
