package SimpleDTUPay;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import SimpleDTUPay.model.Customer;
import SimpleDTUPay.model.Merchant;
import SimpleDTUPay.model.Person;

public class PaymentRegistry {

    public static final ConcurrentHashMap<String, Payment> payment = new ConcurrentHashMap<>();

    static {
        Merchant merchant = new Merchant();
        merchant.setName("Marocco Ltd.");
        merchant.setId();
        PersonRegistry.persons.put(UUID.randomUUID().toString(), merchant);

        Customer customer = new Customer();
        customer.setId();
        customer.setName("Obama bin badem");
        PersonRegistry.persons.put(UUID.randomUUID().toString(), customer);

        Payment payment = new Payment();
        payment.setId();
        payment.setAmount(500);
        payment.setCustomerId(customer.getId());
        payment.setMerchantId(merchant.getId());
        PaymentRegistry.payment.put(UUID.randomUUID().toString(), payment);
    }
}