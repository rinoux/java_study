package cc.rinoux.designpattern.bridgepattern.computers;

import cc.rinoux.designpattern.bridgepattern.AbstractComputer;
import cc.rinoux.designpattern.bridgepattern.CPUPerformance;
import cc.rinoux.designpattern.bridgepattern.GPUPerformance;

/**
 * Created by rinoux on 2017/3/30.
 */
public class ASUS extends AbstractComputer {
    public ASUS(CPUPerformance cpuPerformance, GPUPerformance gpuPerformance) {
        super(cpuPerformance, gpuPerformance);
    }

    @Override
    public double showComputerBenchmark() {
        return getGpuPerformance().benchmark() + getCpuPerformance().benchMark();
    }
}
