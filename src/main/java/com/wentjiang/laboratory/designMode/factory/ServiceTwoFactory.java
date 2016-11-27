package com.wentjiang.laboratory.designMode.factory;

/**
 * Created by wentj on 2016/11/27.
 */
public class ServiceTwoFactory implements ServiceFactory {
    private Service service = new ImplTwoService();
    @Override
    public Service getService() {
        return service;
    }
}
