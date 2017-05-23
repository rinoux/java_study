package cc.rinoux.designpattern.bridgepattern.gpus;

import cc.rinoux.designpattern.bridgepattern.GPUPerformance;

/**
 * Created by rinoux on 2017/3/30.
 */
public class ATI8500 implements GPUPerformance {
    @Override
    public double benchmark() {
        return 2750;
    }
}
