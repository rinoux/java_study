package cc.rinoux.designpattern.bridgepattern.computers;

import cc.rinoux.designpattern.bridgepattern.AbstractComputer;
import cc.rinoux.designpattern.bridgepattern.CPUPerformance;
import cc.rinoux.designpattern.bridgepattern.GPUPerformance;

/**
 * Created by rinoux on 2017/3/30.
 */
public class Lenovo extends AbstractComputer {

    public Lenovo(CPUPerformance cpuPerformance, GPUPerformance gpuPerformance) {
        super(cpuPerformance, gpuPerformance);
    }

    @Override
    public double showComputerBenchmark() {
        return getCpuPerformance().benchMark() + getGpuPerformance().benchmark();
    }
}
