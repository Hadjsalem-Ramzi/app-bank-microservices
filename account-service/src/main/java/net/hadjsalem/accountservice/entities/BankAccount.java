package net.hadjsalem.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.hadjsalem.accountservice.enums.AccountType;
import net.hadjsalem.accountservice.model.Customer;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType  type;

    //private Customer customer ; dans le cas normale en utilisant les jpa ca marche dans l'application monolothique.
    //mais dans l'architecture microservices ,on a besoin  de déclarer un customerId puyis l'utiliser .

    @Transient //on utilise pour ignorer cette classe
    private Customer customer;

    private Long customerId;
}
