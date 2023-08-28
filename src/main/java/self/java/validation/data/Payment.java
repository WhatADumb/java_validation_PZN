package self.java.validation.data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;
import self.java.validation.constraints.CheckOrderId;
import self.java.validation.groups.CreditCardPaymentGroup;
import self.java.validation.groups.VirtualAccountPaymentGroup;
import self.java.validation.payload.EmailErrorPayload;

public class Payment {
    @CheckOrderId(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
    message = "{order.orderId.CheckOrderId}")
    private String orderId;

    @NotNull(groups = {VirtualAccountPaymentGroup.class, CreditCardPaymentGroup.class},
            message = "{order.amount.NotNull}")
    @Range(groups = {VirtualAccountPaymentGroup.class, CreditCardPaymentGroup.class},
            min = 50_000L, max = 1_000_000_000L,
            message = "{order.amount.Range}")
    private Long amount;

    @NotBlank(groups = CreditCardPaymentGroup.class, message = "Credit Card must be fill")
    @LuhnCheck(groups = CreditCardPaymentGroup.class, message = "Credit Card input invalid",
    payload = {EmailErrorPayload.class})
    private String creditCard;
    @NotBlank(groups = VirtualAccountPaymentGroup.class, message = "Virtual Account must be fill")
    private String virtualAccount;

    @Valid
    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}
            , message = "Customer cant be null")
    @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
    @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
    private Customer customer;

    public Payment() {
    }

    public Payment(String orderId, Long amount, String creditCard, String virtualAccount, Customer customer) {
        this.orderId = orderId;
        this.amount = amount;
        this.creditCard = creditCard;
        this.virtualAccount = virtualAccount;
        this.customer = customer;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                ", customer=" + customer +
                '}';
    }
}
