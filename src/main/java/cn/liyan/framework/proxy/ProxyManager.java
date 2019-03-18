package cn.liyan.framework.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.List;

/**
 * create by YanL on 2019/3/15
 */
public class ProxyManager {

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(final Class<?> targetClass, final List<Proxy> proxyList) {
        return (T) Enhancer.create(targetClass, (MethodInterceptor) (o, method, objects, methodProxy)
                -> new ProxyChain(targetClass, o, method, methodProxy, objects, proxyList).doProxyChain());
    }
}
