package com.wentjiang.laboratory.elasticsearch.client;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by jiangwentao on 10/13/2016.
 */
public class ElasticSearchBulkIn {

    public static void main(String[] args) {

        try {

         // cluster.name在elasticsearch.yml中配置

            Client client = TransportClient.builder().build()
                    .addTransportAddress(new InetSocketTransportAddress(
                            InetAddress.getByName("127.0.0.1"), 9300));

            File article = new File(System.getProperty("user.dir")+File.separator+"bulk.txt");
            FileReader fr = new FileReader(article);
            BufferedReader bfr = new BufferedReader(fr);
            String line = null;
            BulkRequestBuilder bulkRequest = client.prepareBulk();
            int count = 0;
            while ((line = bfr.readLine()) != null) {
                bulkRequest.add(client.prepareIndex("test", "article").setSource(line));
                if (count % 10 == 0) {
                    bulkRequest.execute().actionGet();
                }
                count++;
                //System.out.println(line);
            }
            bulkRequest.execute().actionGet();

            bfr.close();
            fr.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
