package com.wentjiang.laboratory.designMode.proxy2;

/**
 * @author jiangwentao
 * @create 2017-12-18 16:07
 * @desc
 **/
public class ClassOne implements TargetOneInterface{
    @Override
    public String method0(String param) {
        System.out.println("this is in classOne method0");
        return param;
    }
}
