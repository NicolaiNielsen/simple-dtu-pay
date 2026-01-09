package SimpleDTUPay.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import SimpleDTUPay.PersonRegistry;
import SimpleDTUPay.model.Customer;

public class CustomerService {

    public CustomerService() {
    }

    public String createCustomer(Customer customer) {
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());
        newCustomer.setCPR(customer.getCPR());
        newCustomer.setId();
        String id = newCustomer.getId();
        PersonRegistry.people.put(id, newCustomer);
        return id;
    }

    public java.util.Collection<Customer> findAll() {
        Collection<Customer> customers = new java.util.ArrayList<>();

        for (Object object : PersonRegistry.people.values()) {
            if (object instanceof Customer) {
                customers.add((Customer) object);
            }
        }
        return customers;
    }

    public Optional<Customer> getCustomerById(String id) {
        System.out.println("Searching for customer with id " + id + " in  person registry");
        Object object = PersonRegistry.people.get(id);
        if (object instanceof Customer) {
            return Optional.of((Customer) object);
        }
        return Optional.empty();
    }

    public Optional<Customer> updateCustomerBankAccount(String id, Customer customer) {

        return Optional.ofNullable(
                (Customer) PersonRegistry.people.computeIfPresent(id, (k, existing) -> {
                    ((Customer) existing).setBankAccountId(customer.getBankAccountId());
                    return existing;
                }));
    }

}
