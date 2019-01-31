package cn.liyan.framework.helper;

import cn.liyan.framework.annotation.Controller;
import cn.liyan.framework.annotation.Service;
import cn.liyan.framework.util.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * create by YanL on 2019/1/9
 */
public final class ClassHelper {

    /**
     * Class Set, contain all class under appoint package
     */
    private static final Set<Class<?>> CLASS_SET;

    /**
     * init CLASS_SET
     * get package name by ConfigHelper and get all Classes by ClassUtil
     */
    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * get class set
     *
     * @return
     */
    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * get classes which carry @Service
     *
     * @return
     */
    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Service.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * get classes which carry @Controller
     *
     * @return
     */
    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Controller.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * get classes which carry @Controller and @Service
     *
     * @return
     */
    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        classSet.addAll(getServiceClassSet());
        classSet.addAll(getControllerClassSet());
        return classSet;
    }
}
