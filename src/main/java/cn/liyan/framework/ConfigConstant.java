package cn.liyan.framework;

/**
 * config constant
 * todo others
 * create by YanL on 2019/1/9
 */
public interface ConfigConstant {

    /**
     * file name
     */
    String CONFIG_FILE = "smart.properties";

    /**
     * jdbc-driver
     */
    String JDBC_DRIVER = "smart.framework.jdbc.driver";
    /**
     * jdbc-url
     */
    String JDBC_URL = "smart.framework.jdbc.url";
    /**
     * jdbc-username
     */
    String JDBC_USERNAME = "smart.framework.jdbc.username";
    /**
     * jdbc-password
     */
    String JDBC_PASSWORD = "smart.framework.jdbc.password";

    /**
     * 源代码基础包名
     */
    String APP_BASE_PACKAGE = "smart.framework.app.base_package";
    /**
     * jsp基础包名
     */
    String APP_JSP_PATH = "smart.framework.app.jsp_path";
    /**
     * 静态文件基础包名
     */
    String APP_ASSET_PATH = "smart.framework.app.asset_path";
}
