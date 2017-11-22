package cc.rinoux.base.java8;

/**
 * Created by rinoux on 2019/8/22.
 */
public interface InterfaceFeatures {

    String CONS = "cons";

    default String getSome(String param) {
        return CONS;
    }


    void getOthers() throws Exception;
}

class Impl implements InterfaceFeatures {

    @Override
    public void getOthers() throws Exception {
        //do sth
    }
}

class Impl2 implements InterfaceFeatures {

    @Override
    public String getSome(String param) {
        return "new";
    }

    @Override
    public void getOthers() throws Exception {
        //do sth
    }
}

