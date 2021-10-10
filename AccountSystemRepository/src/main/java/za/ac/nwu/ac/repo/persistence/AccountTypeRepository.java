package za.ac.nwu.ac.repo.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

    @Modifying
    @Query(value = "UPDATE AccountType a SET a.mnemonic = '$',  a.accountTypeName = 'Dollar', a.createDate = current_date WHERE a.accountTypeId = :accountTypeId")
    int setAccountTypeToDollar(Long accountTypeId);

}
