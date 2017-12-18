package com.wentjiang.laboratory.designMode.proxy.example2;

import lombok.Data;

/**
 * Created by jiangwentao on 2017/8/14 15:03.
 */
@Data
public class Boss implements Drive {

    private Car car;

    @Override
    public String driverCar(Car car) {
        System.out.println("driver car is so funny");
        return "OK";
    }

}
