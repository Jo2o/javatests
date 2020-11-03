package sk.jo2o.javatests.nullLongOperations;

public class NullableLong {

    private Long amount;

    public NullableLong() {
    }

    public NullableLong(Long amount) {
        this.amount = amount;
    }

    public Long add(Long addition) {
        if (addition == null) {
            return null;
        }
        amount += addition;
        return amount;
    }

    public Long substract(Long substraction) {
        if (substraction == null) {
            return amount;
        }
        amount -= substraction;
        return amount;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
