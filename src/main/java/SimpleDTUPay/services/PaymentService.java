package SimpleDTUPay.services;

import java.util.Collection;
import java.util.Optional;

import SimpleDTUPay.Payment;
import SimpleDTUPay.PaymentRegistry;
import SimpleDTUPay.PersonRegistry;
import SimpleDTUPay.model.Merchant;
import SimpleDTUPay.model.Person;

public class PaymentService {

    public String createPayment(Payment payment) {
        Payment newPayment = new Payment();
        newPayment.setId();
        newPayment.setAmount(payment.getAmount());
        newPayment.setCustomerId(payment.getCustomerId());
        newPayment.setMerchantId(payment.getMerchantId());
        System.out.println("Creating payment: customer " + newPayment.getCustomerId() + " paid " + newPayment.getAmount() + " to merchant " + newPayment.getMerchantId());
        SimpleDTUPay.PaymentRegistry.payment.put(newPayment.getId(), newPayment);
        return newPayment.getId();
    }

    public java.util.Collection<Payment> findAll() {
        Collection<Payment> payments = new java.util.ArrayList<>();

        for (Payment payment : PaymentRegistry.payment.values()) {
            payments.add(payment);
        }
        return payments ;
    }

   public Optional<Payment> getPaymentById(String id) {
        Payment payment = PaymentRegistry.payment.get(id);
        if (payment != null) {
            return Optional.of(payment);
        }
        return Optional.empty();
    }
}
