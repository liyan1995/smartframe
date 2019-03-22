package cn.liyan.framework.proxy;

import java.lang.reflect.Method;

/**
 * create by YanL on 2019/3/18
 */
public class AspectProxy implements Proxy {


    /**
     * proxy execute
     * @param proxyChain proxyChain
     * @return
     * @throws Throwable
     */
    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;
        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getMethodParams();

        begin();
        try {
            if (intercept(cls, method, params)) {
                before(cls, method, params);
                result = proxyChain.doProxyChain();
                after(cls, method, params, result);
            }
        } catch (Exception e) {
            error(cls, method, params, e);
        } finally {
            end();
        }
        return result;
    }

    public void begin() {

    }

    public boolean intercept(Class<?> cls, Method method, Object[] params) {
        return true;
    }

    public void before(Class<?> cls, Method method, Object[] params) {

    }

    public void after(Class<?> cls, Method method, Object[] params, Object result) {

    }

    public void error(Class<?> cls, Method method, Object[] params, Throwable e) {

    }

    public void end() {

    }
}
