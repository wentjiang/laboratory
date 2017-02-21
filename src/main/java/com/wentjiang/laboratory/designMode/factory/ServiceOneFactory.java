package com.wentjiang.laboratory.designMode.factory;

/**
 * Created by wentj on 2016/11/27.
 */
public class ServiceOneFactory implements ServiceFactory {
    private Service service = new ImplOneService();
    @Override
    public Service getService() {
        return service;
    }
}
