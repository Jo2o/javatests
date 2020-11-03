package sk.jo2o.javatests.template_pattern;

abstract class OrderProcessTemplate {

    public boolean isGift;

    public abstract void doSelect();

    public abstract void doPayment();

    private void giftWrap() {
        try {
            System.out.println("Gift wrap successfull");
        } catch (Exception e) {
            System.out.println("Gift wrap unsuccessful");
        }
    }

    public abstract void doDelivery();

    final void processOrder(boolean isGift)
    {
        doSelect();
        doPayment();
        if (isGift) {
            giftWrap();
        }
        doDelivery();
    }

}
