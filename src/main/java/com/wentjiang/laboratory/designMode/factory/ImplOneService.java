package com.wentjiang.laboratory.designMode.factory;

/**
 * Created by wentj on 2016/11/27.
 */
public class ImplOneService implements Service {
    @Override
    public void doService() {
        System.out.println("do service in one");
    }

    @Override
    public String showService() {
        return "service one";
    }

    public static ServiceFactory serviceFactory =
            new ServiceFactory() {
                @Override
                public Service getService() {
                    return new ImplOneService();
                }
            };
}
