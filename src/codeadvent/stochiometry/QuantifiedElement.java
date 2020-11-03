package codeadvent.stochiometry;

public class QuantifiedElement {

    private int amount = 0;
    private String name = "";

    public QuantifiedElement(int amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "QuantifiedElement{" +
                "amount=" + amount +
                ", name='" + name + '\'' +
                '}';
    }

}
