package com.wentjiang.laboratory;

/**
 * Created by jiangwentao on 10/13/2016.
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.dir"));
        String str = "curl -XPOST http://localhost:9200/index/fulltext/_mapping -d'" +
                "{" +
                "\"fulltext\": {" +
                "\"_all\": {" +
                "\"analyzer\": \"ik_max_word\"," +
                "\"search_analyzer\": \"ik_max_word\"," +
                "\"term_vector\": \"no\"," +
                "\"store\": \"false\"" +
                "}," +
                "\"properties\": {" +
                "\"content\": {" +
                "\"type\": \"text\"," +
                "\"analyzer\": \"ik_max_word\"," +
                "\"search_analyzer\": \"ik_max_word\"," +
                "\"include_in_all\": \"true\"," +
                "\"boost\": 8" +
                "}" +
                "}" +
                "}" +
                "}'";
        System.out.println(str);

    }
}
