package cc.rinoux.designpattern.builerpattern;

import cc.rinoux.designpattern.builerpattern.components.Engine;
import cc.rinoux.designpattern.builerpattern.components.EscapeTower;
import cc.rinoux.designpattern.builerpattern.components.OrbitalModule;

/**
 * Created by rinoux on 2017/4/4.
 */
public class ShenZhouSpaceShipDirector implements SpaceShipDirector {
    SpaceShipBuilder spaceShipBuilder;
    String shipName;

    public ShenZhouSpaceShipDirector(SpaceShipBuilder spaceShipBuilder, String shipName) {
        this.spaceShipBuilder = spaceShipBuilder;
        this.shipName = shipName;
    }

    @Override
    public SpaceShip directSpaceShip() {
        Engine engine = spaceShipBuilder.buildEngine();
        EscapeTower escapeTower = spaceShipBuilder.buildEscapeTower();
        OrbitalModule orbitalModule =  spaceShipBuilder.buildOrbitalModule();
        System.out.println(shipName + " 建造完成，准备出厂。。。");
        return new ShenZhouSpaceShip(orbitalModule, engine, escapeTower, shipName);
    }
}
