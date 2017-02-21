package com.wentjiang.laboratory.designMode.factory;

/**
 * Created by wentj on 2016/11/27.
 */
public class Test {
    public static void serviceConsumer(ServiceFactory factory){
        Service service = factory.getService();
        service.doService();
        System.out.println(service.showService());
    }

    public static void main(String[] args) {
//        serviceConsumer(new ServiceOneFactory());
//        serviceConsumer(new ServiceTwoFactory());
//        serviceConsumer(ImplOneService::new);       //这是什么语法?
//        serviceConsumer(ImplTwoService.serviceFactory);
    }
}
