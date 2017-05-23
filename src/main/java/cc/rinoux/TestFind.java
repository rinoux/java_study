package cc.rinoux;

import java.util.regex.Pattern;

/**
 * Created by rinoux on 2017/5/19.
 */
public class TestFind {

    static boolean check(String path, String s) {
        Pattern pattern = Pattern.compile(path);
        if (pattern.matcher(s).matches()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(check("*/.html", "/fr/web/core/session.html"));

    }
}
