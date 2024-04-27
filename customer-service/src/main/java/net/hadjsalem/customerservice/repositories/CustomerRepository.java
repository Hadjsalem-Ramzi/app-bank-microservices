package net.hadjsalem.customerservice.repositories;
import net.hadjsalem.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    public Customer findByFirstName(String firstName);
}
