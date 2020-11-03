package designpatterns.visitor;

import java.util.ArrayList;
import java.util.List;

public class ShoppinngCart {

    //normal shopping cart stuff
    private List<Visitable> items = new ArrayList<>();

    public double calculatePostage() {
        //create a visitor
        PostageVisitor visitor = new PostageVisitor();

        //iterate through all items
        for(Visitable item : items) {
            item.accept(visitor);
        }

        double postage = visitor.getTotalPostage();

        return postage;
    }

    public void addToCart(Visitable visitable) {
        items.add(visitable);
    }

}
