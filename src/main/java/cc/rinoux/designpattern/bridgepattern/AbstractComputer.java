package cc.rinoux.designpattern.bridgepattern;

/**
 * Created by rinoux on 2017/3/30.
 */
public abstract class AbstractComputer {
    CPUPerformance cpuPerformance;
    GPUPerformance gpuPerformance;

    public AbstractComputer(CPUPerformance cpuPerformance, GPUPerformance gpuPerformance) {
        this.cpuPerformance = cpuPerformance;
        this.gpuPerformance = gpuPerformance;
    }


    public abstract double showComputerBenchmark();


    public CPUPerformance getCpuPerformance() {
        return cpuPerformance;
    }

    public GPUPerformance getGpuPerformance() {
        return gpuPerformance;
    }
}
