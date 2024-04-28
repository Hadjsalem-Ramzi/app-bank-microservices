package net.hadjsalem.accountservice.dtos;
import lombok.*;
import net.hadjsalem.accountservice.enums.AccountType;
import net.hadjsalem.accountservice.model.Customer;

import java.time.LocalDate;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
public class BankAccountDto {
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    private AccountType type;
    private Customer customer;
    private Long customerId;
}
