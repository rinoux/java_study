package cc.rinoux.designpattern.builerpattern;

import cc.rinoux.designpattern.builerpattern.components.Engine;
import cc.rinoux.designpattern.builerpattern.components.EscapeTower;
import cc.rinoux.designpattern.builerpattern.components.OrbitalModule;

/**
 * Created by rinoux on 2017/4/4.
 */
public class ShenZhouSpaceShipBuilder implements SpaceShipBuilder {
    @Override
    public Engine buildEngine() {
        System.out.println("引擎建造完成");
        return new Engine("神舟飞船引擎");
    }

    @Override
    public EscapeTower buildEscapeTower() {
        System.out.println("逃逸塔建造完成");
        return new EscapeTower("神舟飞船逃逸塔");
    }

    @Override
    public OrbitalModule buildOrbitalModule() {
        System.out.println("轨道舱建造完成");
        return new OrbitalModule("神舟飞船轨道舱");
    }
}
