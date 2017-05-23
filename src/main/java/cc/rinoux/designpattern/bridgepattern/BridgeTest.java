package cc.rinoux.designpattern.bridgepattern;

import cc.rinoux.designpattern.bridgepattern.computers.Lenovo;
import cc.rinoux.designpattern.bridgepattern.cpus.IntelI7;
import cc.rinoux.designpattern.bridgepattern.gpus.ATI8500;

/**
 * Created by rinoux on 2017/3/30.
 */
public class BridgeTest {

    public static void main(String[] args) {
        GPUPerformance gpu = new ATI8500();
        CPUPerformance cpu = new IntelI7();

        AbstractComputer computer = new Lenovo(cpu, gpu);
        System.out.println(computer.showComputerBenchmark());
    }
}
