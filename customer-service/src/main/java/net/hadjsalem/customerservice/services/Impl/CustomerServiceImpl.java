package net.hadjsalem.customerservice.services.Impl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hadjsalem.customerservice.dtos.CustomerDTO;
import net.hadjsalem.customerservice.entities.Customer;
import net.hadjsalem.customerservice.mapper.CustomerMapper;
import net.hadjsalem.customerservice.repositories.CustomerRepository;
import net.hadjsalem.customerservice.services.CustomerService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;




@Service
public class CustomerServiceImpl implements CustomerService {

  private CustomerRepository customerRepository;

  private CustomerMapper customerMapper;

  public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
    this.customerRepository = customerRepository;
    this.customerMapper = customerMapper;
  }

  @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
      Customer customer = customerMapper.from(customerDTO);
      Customer customer1 =customerRepository.save(customer);
      return customerMapper.from(customer1);
    }

    @Override
    public CustomerDTO findById(Long id) {
      Optional<Customer> optionalCustomer = customerRepository.findById(id);
      return optionalCustomer.map(customerMapper::from).orElseThrow(()->new NoSuchElementException("Customer not Found"));
    }

    @Override
    public CustomerDTO findByFirstName(String firstName) {
        Customer customer = customerRepository.findByFirstName(firstName);
        return customerMapper.from(customer);

    }

    @Override
    public List<CustomerDTO> listCustomers() {
    List<Customer> customers = customerRepository.findAll();
    return customers.stream().map(customerMapper::from).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO, Long id) {
       Optional<Customer>customer =customerRepository.findById(id);
       if(customer.isPresent()){
         Customer customer1 = customer.get();
         Customer customer2 = customerRepository.saveAndFlush(customer1);
         return customerMapper.from(customer2);
       }else {
         throw  new RuntimeException("customer not Found");
       }
    }

    @Override
    public void delete(Long id) {
      customerRepository.deleteById(id);

    }
}
