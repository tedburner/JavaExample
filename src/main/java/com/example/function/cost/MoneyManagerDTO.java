package com.example.function.cost;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @author: lingjun.jlj
 * @date: 2020/1/12 10:35
 * @description: MoneyManager 导入的数据
 */
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "MoneyManagerDTO{" +
                "time='" + time + '\'' +
                ", costType='" + costType + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}
