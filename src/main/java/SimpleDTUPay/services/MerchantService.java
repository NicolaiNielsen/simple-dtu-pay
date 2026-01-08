package SimpleDTUPay.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import SimpleDTUPay.PersonRegistry;
import SimpleDTUPay.model.Customer;
import SimpleDTUPay.model.Merchant;
import SimpleDTUPay.model.Person;

public class MerchantService {

    public MerchantService() {
    }

    public String createMerchant(Merchant merchant) {
        Merchant newMerchant = new Merchant();
        newMerchant.setName(merchant.getName());
        newMerchant.setId();
        String id = newMerchant.getId();
        PersonRegistry.persons.put(id, newMerchant);
        return id;
    }

    public java.util.Collection<Merchant> findAll() {
        Collection<Merchant> merchants = new java.util.ArrayList<>();

        for (Person person : PersonRegistry.persons.values()) {
            if (person instanceof Merchant) {
                merchants.add((Merchant) person);
            }
        }
        return merchants;
    }

    public Optional<Merchant> getMerchantById(String id) {
        Person person = PersonRegistry.persons.get(id);
        if (person instanceof Merchant) {
            return Optional.of((Merchant) person);
        }
        return Optional.empty();
    }
}
