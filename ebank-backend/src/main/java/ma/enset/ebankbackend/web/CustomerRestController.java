package ma.enset.ebankbackend.web;

import ma.enset.ebankbackend.dtos.AccountOperationDTO;
import ma.enset.ebankbackend.dtos.CustomerDTO;
import ma.enset.ebankbackend.entities.Customer;
import ma.enset.ebankbackend.exceptions.CustomerNotFoundException;
import ma.enset.ebankbackend.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CustomerRestController {
    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping("/customers")
    public List<CustomerDTO> customers(){
        return bankAccountService.listCustomers();
    }

    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomerById(@PathVariable(name = "id") Long customerId) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(customerId);
    }

    @PostMapping("/customers")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) throws CustomerNotFoundException {
        return bankAccountService.saveCustomer(customerDTO);
    }

    @PutMapping("customers/{customerId}")
    public CustomerDTO updateCustomer(@PathVariable Long customerId,@RequestBody CustomerDTO customerDTO) throws CustomerNotFoundException {
        customerDTO.setId(customerId);
        bankAccountService.updateCustomer(customerDTO);
        return bankAccountService.getCustomer(customerId);
    }

    @DeleteMapping("/customers/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId) throws CustomerNotFoundException {
        bankAccountService.deleteCustomer(customerId);
    }

}
