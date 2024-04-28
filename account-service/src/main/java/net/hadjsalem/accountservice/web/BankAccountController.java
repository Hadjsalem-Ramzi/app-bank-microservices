package net.hadjsalem.accountservice.web;


import lombok.NoArgsConstructor;
import net.hadjsalem.accountservice.clients.CustomerRestClient;
import net.hadjsalem.accountservice.dtos.BankAccountDto;
import net.hadjsalem.accountservice.model.Customer;
import net.hadjsalem.accountservice.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Accounts")
@NoArgsConstructor
public class BankAccountController {

    @Autowired
    private BankAccountService  bankAccountService;

    @Autowired
    private CustomerRestClient customerRestClient;

    public BankAccountController(BankAccountService bankAccountService, CustomerRestClient customerRestClient) {
        this.bankAccountService = bankAccountService;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("findBankAccountById/{id}")
    public BankAccountDto findBankAccountById(@PathVariable("id") String id){
        BankAccountDto bankAccountdto = bankAccountService.findById(id);
        // Récupérer le client correspondant à ce compte bancaire
        Customer customer = customerRestClient.findCustomerById(bankAccountdto.getCustomerId());

        // Assurez-vous que l'identifiant du client est défini dans le DTO
        bankAccountdto.setCustomerId(customer.getCustomerId());

        // Définir le client dans le DTO
        bankAccountdto.setCustomer(customer);

        return bankAccountdto;
    }

    @GetMapping("findBankAccountByBalance/{balance}")
    public BankAccountDto findBankAccountByBalance(@PathVariable("balance") String balance){
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
