package cc.rinoux.designpattern.proxypattern.dynamic;

/**
 * 委托者
 *
 * Created by rinoux on 2017/2/16.
 */
public class UserServiceDelegate implements UserService {

    @Override
    public String getName(int id) {
        System.out.println("自己执行getName");
        if (id == 1) return "Jim";
        return "Tom";
    }

    @Override
    public Integer getAge(int id) {
        System.out.println("自己执行getAge");
        if (id == 1) return 12;
        return 10;
    }
}
