interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPal {
    public void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " processed using PayPal.");
    }
}

class Stripe {
    public void pay(double amount) {
        System.out.println("Payment of $" + amount + " processed using Stripe.");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.pay(amount);
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());

        paypalProcessor.processPayment(100.00);
        stripeProcessor.processPayment(200.00);
    }
}
