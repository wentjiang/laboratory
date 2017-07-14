package com.wentjiang.laboratory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by jiangwentao on 2017/6/21 12:27.
 */
@Data
@Builder
@Accessors(chain = true)
@AllArgsConstructor
public class User {

    private String name;

    private int age;

}
