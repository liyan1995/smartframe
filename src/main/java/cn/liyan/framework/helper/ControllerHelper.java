package cn.liyan.framework.helper;

import cn.liyan.framework.annotation.Action;
import cn.liyan.framework.bean.Handler;
import cn.liyan.framework.bean.Request;
import cn.liyan.framework.util.CollectionUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * create by YanL on 2019/1/9
 */
public final class ControllerHelper {

    /**
     * Request(method(String),path(String)) ---mapping--- Handler(controllerClass(Class),actionMethod(Method))
     * like: GET:/hello ---mapping--- HelloController().hello()
     */
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    /**
     * init ACTION_MAP container
     * collect all Classes which carry @Controller
     * and loop Classes to collect all Methods which carry @Action
     * and put them to ACTION_MAP container
     */
    static {
        /**
         * get all Classes which carry @Controller
         */
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            /**
             * loop controllerClassSet
             * get all Methods which carry @Action from each class
             * instance Request and Handler put to ACTION_MAP
             */
            for (Class<?> controllerClass : controllerClassSet) {
                Method[] methods = controllerClass.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(Action.class)) {
                        Action action = method.getAnnotation(Action.class);
                        String mapping = action.value();
                        if (mapping.matches("\\w+:/\\w*")) {
                            String[] array = mapping.split(":");
                            if (ArrayUtils.isNotEmpty(array) && array.length == 2) {
                                String requestMethod = array[0];
                                String requestPath = array[1];
                                Request request = new Request(requestMethod, requestPath);
                                Handler handler = new Handler(controllerClass, method);
                                ACTION_MAP.put(request, handler);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * get Handler(Class,Method)
     * @param requestMethod
     * @param requestPath
     * @return
     */
    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }

}
