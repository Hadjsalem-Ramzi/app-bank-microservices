package net.hadjsalem.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.hadjsalem.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/Customers/findCustomerById/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable("id") Long id);

    @CircuitBreaker(name = "customerService",fallbackMethod = "getAllCustomers")

    @GetMapping("/Customers/ListCustomers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id,Exception exception){
        Customer customer = new Customer();
        customer.setCustomerId(id);
        customer.setFirstName("Not vailable");
        customer.setLastName("Not vailable");
        customer.setEmail("Not vailable");
       return customer;
    }

    default List<Customer> getAllCustomers(Exception exception){
        return List.of();
    }




}
