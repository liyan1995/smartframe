package cn.liyan.framework.bean;

import java.lang.reflect.Method;

/**
 * 处理类
 *
 * create by YanL on 2019/1/9
 */
public class Handler {

    private Class<?> controllerClass;
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
