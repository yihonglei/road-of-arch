package com.jpeony.sharding.jdbc.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * @author yihonglei
 */
@Data
@Builder
public class User {
    private Long id;
    private String userName;
    private int age;
    private String address;
}
