package net.hadjsalem.accountservice.services;

import net.hadjsalem.accountservice.dtos.BankAccountDto;

import java.util.List;

public interface BankAccountService {

 BankAccountDto findById(String id);

 BankAccountDto findBankAccountByBalance(Double balance);

 BankAccountDto save (BankAccountDto bankAccountDto);

 BankAccountDto update (BankAccountDto bankAccountDto,String id);

 List<BankAccountDto> ListBankAccounts();

 void delete(String id);

}
