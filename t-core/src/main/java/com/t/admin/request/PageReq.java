package com.t.admin.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author tb
 * @date 2018/12/17 14:30
 */
@Getter
@Setter
public class PageReq {
    private Integer start = 0;

    private Integer limit = 10;

    private String field;

    private String direction;
}
