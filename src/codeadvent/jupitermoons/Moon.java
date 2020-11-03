package codeadvent.jupitermoons;

public class Moon {

    private String name;
    private Vector position;
    private Vector velocity;

    public Moon(String name, Vector position, Vector velocity) {
        this.name = name;
        this.position = position;
        this.velocity = velocity;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    @Override
    public String toString() {
        return name + "{position=" + position + ", velocity=" + velocity + '}';
    }

}
