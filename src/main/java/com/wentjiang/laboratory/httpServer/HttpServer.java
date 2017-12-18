package com.wentjiang.laboratory.httpServer;

import java.io.File;

/**
 * Created by jiangwentao on 2017/8/15 11:06.
 */
public class HttpServer {

    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";

    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
}
