package net.hadjsalem.accountservice.web;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.hadjsalem.accountservice.dtos.BankAccountDto;
import net.hadjsalem.accountservice.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("BankAccount/")
@NoArgsConstructor
public class BankAccountController {

    @Autowired
    private BankAccountService  bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("findBankAccountById/{id}")
    public BankAccountDto findBankAccountById(@PathVariable("id") String id){
        return bankAccountService.findById(id);
    }

    @GetMapping("findBankAccountByBalance/{balance}")
    public BankAccountDto findBankAccountByBalance(@PathVariable("id") String balance){
        return bankAccountService.findById(balance);
    }

    @GetMapping("ListBankAccounts")
    public List<BankAccountDto> ListBankAccounts(){
        return bankAccountService.ListBankAccounts();
    }

    @PostMapping("saveBankAccount")
    public BankAccountDto saveBankAccount(@RequestBody BankAccountDto bankAccountdto ){
       return bankAccountService.save(bankAccountdto);
    }

    @PutMapping("updateBankAccount/{id}")
    public BankAccountDto updateBankAccount (@RequestBody BankAccountDto bankAccountdto , @PathVariable("id") String id){
        return bankAccountService.update(bankAccountdto,id);
    }

    @DeleteMapping("deleteBankAccount/{id}")
    public void deleteBankAccount(@PathVariable("id") String id){
        bankAccountService.delete(id);
    }

}
