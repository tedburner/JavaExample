package com.example.function.cost;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author: lingjun.jlj
 * @date: 2020/1/12 10:35
 * @description: MoneyManager 导入的数据
 */
@Data
public class MoneyManagerDTO {

    @ExcelProperty(value = "日期")
    private String time;

    /**
     * 收入/支出
     */
    @ExcelProperty(value = "收入/支出")
    private String costType;

    /**
     * 类别
     */
    @ExcelProperty(value = "类别")
    private String type;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String content;

    /**
     * 花费
     */
    @ExcelProperty(value = "合计")
    private String cost;

}
