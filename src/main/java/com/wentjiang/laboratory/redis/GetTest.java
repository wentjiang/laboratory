package com.wentjiang.laboratory.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by jiangwentao on 10/18/2016.
 */
public class GetTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1");
        String keys = "name";

//// 删数据
//        jedis.del(keys);
//// 存数据
//        jedis.set(keys, "snowolf");
//// 取数据
//        String value = jedis.get(keys);

        System.out.println(jedis.get(keys));
    }
}
