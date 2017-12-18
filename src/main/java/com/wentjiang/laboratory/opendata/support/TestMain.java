package com.wentjiang.laboratory.opendata.support;

/**
 * Created by jiangwentao on 2017/8/21 14:32.
 */
public class TestMain {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            final int page = i;
            Thread thread = new Thread(() -> {
                HttpClientBuilder builder = HttpClientBuilder.getBuilder();
                SteamRequester steamRequester = new SteamRequester(builder);
                steamRequester.getSearchInfo("习近平", page);
            });
            System.out.println("thread 1 start");
            thread.start();
        }
    }

}
