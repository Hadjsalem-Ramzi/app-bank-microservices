package net.hadjsalem.accountservice.repositories;

import net.hadjsalem.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {

    public BankAccount findBankAccountByBalance(Double balance);
}
