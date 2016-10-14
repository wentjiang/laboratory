package com.wentjiang.laboratory.elasticsearch.client;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by jiangwentao on 10/13/2016.
 */
public class ElasticSearchBulkOut {

    public static void main(String[] args) {

        try {
//            Settings settings = Settings.settingsBuilder()
//                    .put("cluster.name", "bropen").build();// cluster.name在elasticsearch.yml

            Client client = TransportClient.builder().build()
                    .addTransportAddress(new InetSocketTransportAddress(
                            InetAddress.getByName("127.0.0.1"), 9300));

            QueryBuilder qb = QueryBuilders.matchAllQuery();
            SearchResponse response = client.prepareSearch("blog")
                    .setTypes("article").setQuery(QueryBuilders.matchAllQuery())
                    .execute().actionGet();
            SearchHits resultHits = response.getHits();

            File article = new File(System.getProperty("user.dir")+File.separator+"bulk.txt");
            FileWriter fw = new FileWriter(article);
            BufferedWriter bfw = new BufferedWriter(fw);

            if (resultHits.getHits().length == 0) {
                System.out.println("查到0条数据!");

            } else {
                for (int i = 0; i < resultHits.getHits().length; i++) {
                    String jsonStr = resultHits.getHits()[i]
                            .getSourceAsString();
                    System.out.println(jsonStr);
                    bfw.write(jsonStr);
                    bfw.write("\n");
                }
            }
            bfw.close();
            fw.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
