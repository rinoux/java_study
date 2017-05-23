package cc.rinoux.annotations;

/**
 * Created by rinoux on 2017/3/15.
 */
public @interface Plugin {

    String type() default "illegal plugin";
}
