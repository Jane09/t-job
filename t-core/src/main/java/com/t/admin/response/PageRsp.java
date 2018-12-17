package com.t.admin.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页返回响应
 * @author tb
 * @date 2018/12/17 14:32
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageRsp<T> {

    private int results = 0;
    private List<T> rows = new ArrayList<>();
}
