package com.example.function.cost;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author: lingjun.jlj
 * @date: 2020/1/12 11:10
 * @description: 网友有钱
 */
@Data
public class YouQianDTO {

    @ExcelProperty(value = "账号")
    private String account;

    @ExcelProperty(value = "金额")
    private String amount;

    @ExcelProperty(value = "时间")
    private String time;

    @ExcelProperty(value = "分类")
    private String type;

    @ExcelProperty(value = "币种")
    private String moneyType;

    @ExcelProperty(value = "备注")
    private String content;

}
