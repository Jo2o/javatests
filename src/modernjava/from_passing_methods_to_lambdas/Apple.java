package modernjava.from_passing_methods_to_lambdas;

public class Apple {

    private String color;
    private int weight;

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public static boolean isGreen(Apple a) {
        return "GREEN".equalsIgnoreCase(a.getColor());
    }

    public static boolean isHeavy(Apple a) {
        return a.getWeight() > 100;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
    }

}
