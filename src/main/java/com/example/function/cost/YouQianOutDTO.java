package com.example.function.cost;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author: lingjun.jlj
 * @date: 2020/1/12 11:10
 * @description: 网友有钱
 */
public class YouQianOutDTO {

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

    @ExcelProperty(value = "报销")
    private String reimbursement;

    @ExcelProperty(value = "备注")
    private String content;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(String reimbursement) {
        this.reimbursement = reimbursement;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "YouQianOutDTO{" +
                "account='" + account + '\'' +
                ", amount='" + amount + '\'' +
                ", time='" + time + '\'' +
                ", type='" + type + '\'' +
                ", moneyType='" + moneyType + '\'' +
                ", reimbursement='" + reimbursement + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
