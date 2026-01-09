package SimpleDTUPay;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import SimpleDTUPay.model.Customer;
import SimpleDTUPay.model.Merchant;

public class PersonRegistry {

    public static final ConcurrentHashMap<String, Object> people = new ConcurrentHashMap<>();

    static {
        Merchant merchant = new Merchant();
        merchant.setFirstName("Potato Inc.");
        merchant.setLastName("Company");
        merchant.setCPR("123456-7890");
        merchant.setId();
        people.put(merchant.getId(), merchant);

        Customer customer = new Customer();
        customer.setId();
        customer.setFirstName("Joey");
        customer.setLastName("Tribbiani");
        customer.setCPR("123456-7890");
        people.put(customer.getId(), customer);
    }
}