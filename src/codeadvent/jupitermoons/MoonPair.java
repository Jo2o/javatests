package codeadvent.jupitermoons;

public class MoonPair {

    private Moon moon1;
    private Moon moon2;

    public MoonPair(Moon moon1, Moon moon2) {
        this.moon1 = moon1;
        this.moon2 = moon2;
    }

    public Moon getMoon1() {
        return moon1;
    }

    public Moon getMoon2() {
        return moon2;
    }

}
