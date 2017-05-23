package cc.rinoux.designpattern.builerpattern;

import cc.rinoux.designpattern.builerpattern.components.Engine;
import cc.rinoux.designpattern.builerpattern.components.EscapeTower;
import cc.rinoux.designpattern.builerpattern.components.OrbitalModule;

/**
 * Created by rinoux on 2017/4/4.
 */
public class ShenZhouSpaceShip extends SpaceShip {
    String name;

    public ShenZhouSpaceShip(OrbitalModule orbitalModule, Engine engine, EscapeTower escapeTower, String name) {
        super(orbitalModule, engine, escapeTower);
        this.name = name;
    }
}
