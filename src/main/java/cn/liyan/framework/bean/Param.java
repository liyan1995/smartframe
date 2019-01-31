package cn.liyan.framework.bean;

import cn.liyan.framework.util.CastUtil;

import java.util.Map;

/**
 * create by YanL on 2019/1/9
 */
public class Param {
    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }
}
