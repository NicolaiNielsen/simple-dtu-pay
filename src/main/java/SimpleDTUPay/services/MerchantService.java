package SimpleDTUPay.services;

import java.util.Collection;
import java.util.Optional;
import SimpleDTUPay.PersonRegistry;
import SimpleDTUPay.model.Customer;
import SimpleDTUPay.model.Merchant;

public class MerchantService {

    public MerchantService() {
    }

    public String createMerchant(Merchant merchant) {
        Merchant newMerchant = new Merchant();
        newMerchant.setFirstName(merchant.getFirstName());
        newMerchant.setLastName(merchant.getLastName());
        newMerchant.setCPR(merchant.getCPR());
        newMerchant.setId();
        String id = newMerchant.getId();
        PersonRegistry.people.put(id, newMerchant);
        return id;
    }

    public java.util.Collection<Merchant> findAll() {
        Collection<Merchant> merchants = new java.util.ArrayList<>();

        for (Object object : PersonRegistry.people.values()) {
            if (object instanceof Merchant) {
                merchants.add((Merchant) object);
            }
        }
        return merchants;
    }

    public Optional<Merchant> getMerchantById(String id) {
        Object object = PersonRegistry.people.get(id);
        if (object instanceof Merchant) {
            return Optional.of((Merchant) object);
        }
        return Optional.empty();
    }

    public Optional<Merchant> updateMerchantBankAccount(String id, Merchant merchant) {

        return Optional.ofNullable(
                (Merchant) PersonRegistry.people.computeIfPresent(id, (k, existing) -> {
                    ((Merchant) existing).setBankAccountId(merchant.getBankAccountId());
                    return existing;
                }));
    }
}
