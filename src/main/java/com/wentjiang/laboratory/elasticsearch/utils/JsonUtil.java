package com.wentjiang.laboratory.elasticsearch.utils;

import com.wentjiang.laboratory.elasticsearch.model.Blog;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;

/**
 * Created by jiangwentao on 10/13/2016.
 */
public class JsonUtil {

    // Java实体对象转json对象
    public static String model2Json(Blog blog) {
        String jsonData = null;
        try {
            XContentBuilder jsonBuild = XContentFactory.jsonBuilder();
            jsonBuild.startObject().field("id", blog.getId()).field("title", blog.getTitle())
                    .field("posttime", blog.getPosttime()).field("content",blog.getContent())
                    .endObject();

            jsonData = jsonBuild.string();
            //System.out.println(jsonData);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonData;
    }

}
