package SimpleDTUPay;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import SimpleDTUPay.model.Customer;
import SimpleDTUPay.model.Merchant;

public class PaymentRegistry {

    public static final ConcurrentHashMap<String, Payment> payment = new ConcurrentHashMap<>();

    static {
        Merchant merchant = new Merchant();
        merchant.setFirstName("Marocco Ltd.");
        merchant.setLastName("Company");
        merchant.setCPR("123456-7890");
        merchant.setId();
        PersonRegistry.people.put(merchant.getId(), merchant);

        Customer customer = new Customer();
        customer.setId();
        customer.setFirstName("Obama bin badem");
        customer.setLastName("Badem");
        customer.setCPR("987654-3210");
        PersonRegistry.people.put(customer.getId(), customer);

        Payment payment = new Payment();
        payment.setId();
        payment.setAmount(500);
        payment.setCustomerId(customer.getId());
        payment.setMerchantId(merchant.getId());
        PaymentRegistry.payment.put(UUID.randomUUID().toString(), payment);
    }
}