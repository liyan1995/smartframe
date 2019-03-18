package cn.liyan.framework;

import cn.liyan.framework.helper.*;
import cn.liyan.framework.util.ClassUtil;

/**
 * create by YanL on 2019/1/9
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {ClassHelper.class, BeanHelper.class, AopHelper.class, IocHelper.class, ControllerHelper.class};
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), true);
        }
    }
}
