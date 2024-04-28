package net.hadjsalem.customerservice.web;
import net.hadjsalem.customerservice.dtos.CustomerDTO;
import net.hadjsalem.customerservice.services.CustomerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("Customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("findCustomerById/{id}")
    public CustomerDTO findById(@PathVariable("id") Long id){
        return customerService.findById(id);
    }

    @GetMapping("findCustomerByFirstName/{firstname}")
    public CustomerDTO findByFirstName(@PathVariable("firstname") String firstname){
        return customerService.findByFirstName(firstname);
    }

    @GetMapping("ListCustomers")
    public List<CustomerDTO> ListCustomers(){
        return customerService.listCustomers();
    }

    @PostMapping("saveCustomer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerdto){
        return customerService.save(customerdto);
    }

    @PutMapping("updateCustomer/{id}")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerdto,@PathVariable("id") Long id){
        return customerService.update(customerdto,id);
    }

    @DeleteMapping("deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable("id") Long id){
        customerService.delete(id);
    }


}
