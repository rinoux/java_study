package cc.rinoux.designpattern.builerpattern;

import cc.rinoux.designpattern.builerpattern.components.Engine;
import cc.rinoux.designpattern.builerpattern.components.EscapeTower;
import cc.rinoux.designpattern.builerpattern.components.OrbitalModule;

/**
 * Created by rinoux on 2017/4/4.
 */
public abstract class SpaceShip {

    private OrbitalModule orbitalModule;
    private Engine engine;
    private EscapeTower escapeTower;

    public SpaceShip(OrbitalModule orbitalModule, Engine engine, EscapeTower escapeTower) {
        this.orbitalModule = orbitalModule;
        this.engine = engine;
        this.escapeTower = escapeTower;
    }

    public OrbitalModule getOrbitalModule() {
        return orbitalModule;
    }

    public void setOrbitalModule(OrbitalModule orbitalModule) {
        this.orbitalModule = orbitalModule;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public EscapeTower getEscapeTower() {
        return escapeTower;
    }

    public void setEscapeTower(EscapeTower escapeTower) {
        this.escapeTower = escapeTower;
    }
}
