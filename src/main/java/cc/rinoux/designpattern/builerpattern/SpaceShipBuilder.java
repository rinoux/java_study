package cc.rinoux.designpattern.builerpattern;

import cc.rinoux.designpattern.builerpattern.components.Engine;
import cc.rinoux.designpattern.builerpattern.components.EscapeTower;
import cc.rinoux.designpattern.builerpattern.components.OrbitalModule;

/**
 * 建造者接口
 *
 * Created by rinoux on 2017/4/4.
 */
public interface SpaceShipBuilder {
    Engine buildEngine();
    EscapeTower buildEscapeTower();
    OrbitalModule buildOrbitalModule();
}
