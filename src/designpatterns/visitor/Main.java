package designpatterns.visitor;

public class Main {

    public static void main(String[] args) {
        ShoppinngCart shoppinngCart = new ShoppinngCart();
        shoppinngCart.addToCart(new Book(20.0, 20.0));
        shoppinngCart.addToCart(new Book(20.0, 20.0));
        shoppinngCart.addToCart(new Book(20.0, 20.0));

        System.out.println("Postage price:" + shoppinngCart.calculatePostage());
    }

}
