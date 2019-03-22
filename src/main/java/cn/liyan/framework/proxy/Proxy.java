package cn.liyan.framework.proxy;

/**
 * create by YanL on 2019/3/15
 */
public interface Proxy {

    /**
     * proxy execute
     * @param proxyChain
     * @return
     * @throws Throwable
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
