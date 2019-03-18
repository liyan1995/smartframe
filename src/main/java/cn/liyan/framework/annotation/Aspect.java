package cn.liyan.framework.annotation;

import java.lang.annotation.*;

/**
 * create by YanL on 2019/3/15
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    Class<? extends Annotation> value();
}
