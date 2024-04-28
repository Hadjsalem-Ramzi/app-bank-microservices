package net.hadjsalem.accountservice.model;

import lombok.*;

@Getter @Setter
public class Customer {
    private Long customerId ;
    private String firstName;
    private String lastName;
    private String email;
}
