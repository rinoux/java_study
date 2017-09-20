package cc.rinoux.designpattern.commandpattern;

public class Light {
    String place;

    public Light(String place) {
        this.place = place;
    }

    public void on() {
        System.out.println("light on");
    }

    public void off() {
        System.out.println(place + " light off");
    }
}
