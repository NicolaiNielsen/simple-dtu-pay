package SimpleDTUPay;

public class Payment {

    private String id;
    private Integer amount;
    private String customerId;
    private String merchantId;

    public Payment() {
    }

    public void setId() {
        this.id = java.util.UUID.randomUUID().toString();
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getAmount() {
        return amount;
    }
    public String getCustomerId() {
        return customerId;
    }
    public String getId() {
        return id;
    }
    public String getMerchantId() {
        return merchantId;
    }

    @Override
    public String toString() {
        return "Payment [amount=" + amount + ", customerId=" + customerId + ", merchantId=" + merchantId + "]";
    }

}
