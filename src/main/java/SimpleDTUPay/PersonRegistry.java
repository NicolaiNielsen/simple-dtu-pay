package SimpleDTUPay;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import SimpleDTUPay.model.Customer;
import SimpleDTUPay.model.Merchant;
import SimpleDTUPay.model.Person;

public class PersonRegistry {
    
    public static final ConcurrentHashMap<String, Person> persons = new ConcurrentHashMap<>();
    
    static {
        Merchant merchant = new Merchant();
        merchant.setName("Potato Inc.");
        merchant.setId();
        persons.put(UUID.randomUUID().toString(), merchant);

        Customer customer = new Customer();
        customer.setId();
        customer.setName("Joey Tribbiani");
        persons.put(UUID.randomUUID().toString(), customer);
    }
}   