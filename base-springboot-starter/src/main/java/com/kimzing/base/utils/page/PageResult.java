package com.kimzing.base.utils.page;

import lombok.Data;

import java.util.List;

/**
 * 分页结果.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/5 15:33
 */
@Data
public class PageResult<T> {

    public PageResult(Long total, Integer pageNum, Integer pageSize, List<T> data) {
        this.total = total;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.data = data;
    }

    private Long total;

    private Integer pageNum;

    private Integer pageSize;

    private List<T> data;

}
