package net.hadjsalem.accountservice.services.Impl;
import lombok.NoArgsConstructor;
import net.hadjsalem.accountservice.dtos.BankAccountDto;
import net.hadjsalem.accountservice.entities.BankAccount;
import net.hadjsalem.accountservice.mapper.BankAccountMapper;
import net.hadjsalem.accountservice.repositories.BankAccountRepository;
import net.hadjsalem.accountservice.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class BankAccountImpl implements BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private BankAccountMapper bankAccountMapper;

    public BankAccountImpl(BankAccountRepository bankAccountRepository, BankAccountMapper bankAccountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapper = bankAccountMapper;
    }





    @Override
    public BankAccountDto findById(String id) {
        Optional<BankAccount> bankAccount = bankAccountRepository.findById(id);

        return bankAccount.map(bankAccountMapper::from).orElseThrow(()->new NoSuchElementException("BankAccount not Found"));

    }

    @Override
    public BankAccountDto findBankAccountByBalance(Double balance) {
        Optional<BankAccount> bankAccount = Optional.ofNullable(bankAccountRepository.findBankAccountByBalance(balance));

        return  bankAccount.map(bankAccountMapper::from).orElseThrow(()-> new NoSuchElementException("BankAccount Notfound"));

    }

    @Override
    public BankAccountDto save(BankAccountDto bankAccountDto) {
       BankAccount bankAccount = bankAccountMapper.from(bankAccountDto);
       BankAccount bankAccount1= bankAccountRepository.save(bankAccount);
       return bankAccountMapper.from(bankAccount1);
    }

    @Override
    public BankAccountDto update(BankAccountDto bankAccountDto, String id) {
      Optional<BankAccount> bankAccount = bankAccountRepository.findById(id);
      if(bankAccount.isPresent()){
          BankAccount bankAccount1 = bankAccount.get();

          BankAccount bankAccount2 = bankAccountRepository.save(bankAccount1);

          return  bankAccountMapper.from(bankAccount2);

      }else {
          throw  new RuntimeException("BankAccountNotFound");
      }

    }

    @Override
    public List<BankAccountDto> ListBankAccounts() {
      List<BankAccount> bankAccountList = bankAccountRepository.findAll();
      return  bankAccountList.stream().map(bankAccountMapper::from).collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
     bankAccountRepository.deleteById(id);
    }
}
