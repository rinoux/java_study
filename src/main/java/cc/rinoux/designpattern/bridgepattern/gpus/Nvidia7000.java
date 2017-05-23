package cc.rinoux.designpattern.bridgepattern.gpus;

import cc.rinoux.designpattern.bridgepattern.GPUPerformance;

/**
 * Created by rinoux on 2017/3/30.
 */
public class Nvidia7000 implements GPUPerformance {
    @Override
    public double benchmark() {
        return 3000;
    }
}
