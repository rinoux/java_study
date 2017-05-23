package cc.rinoux.designpattern.bridgepattern.cpus;

import cc.rinoux.designpattern.bridgepattern.CPUPerformance;

/**
 * Created by rinoux on 2017/3/30.
 */
public class AMDA8 implements CPUPerformance {
    @Override
    public double benchMark() {
        return 8700;
    }
}
