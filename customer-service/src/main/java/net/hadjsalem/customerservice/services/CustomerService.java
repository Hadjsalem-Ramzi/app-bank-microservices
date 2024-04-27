package net.hadjsalem.customerservice.services;
import net.hadjsalem.customerservice.dtos.CustomerDTO;

import java.util.List;

public interface CustomerService {

   CustomerDTO save (CustomerDTO customerDTO);

     CustomerDTO findById(Long id);

     CustomerDTO findByFirstName(String firstName);

     List<CustomerDTO> listCustomers();

     CustomerDTO update(CustomerDTO customerDTO,Long id);

     void delete(Long id);



}
