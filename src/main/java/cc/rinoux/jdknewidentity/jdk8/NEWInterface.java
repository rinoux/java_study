package cc.rinoux.jdknewidentity.jdk8;

/**
 * Created by rinoux on 2017/3/31.
 */
public interface NEWInterface {

    void doSth1(int param);
    void doSth(int param);
    default String getVersion() {
        return "1.0";
    }
}
