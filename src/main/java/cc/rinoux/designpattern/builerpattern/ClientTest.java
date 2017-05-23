package cc.rinoux.designpattern.builerpattern;

/**
 * Created by rinoux on 2017/4/4.
 */
public class ClientTest {

    public static void main(String[] args) {
        SpaceShipBuilder builder = new ShenZhouSpaceShipBuilder();
        SpaceShipDirector director = new ShenZhouSpaceShipDirector(builder, "ShenZhou-11");
        SpaceShip ship = director.directSpaceShip();
    }
}
