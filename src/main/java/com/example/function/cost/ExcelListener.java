package com.example.function.cost;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.utils.DateFormatUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author: lingjun.jlj
 * @date: 2020/1/12 10:49
 * @description:
 */
public class ExcelListener extends AnalysisEventListener<MoneyManagerDTO> {

    public static List<YouQianOutDTO> outList = new ArrayList<>();
    public static List<YouQianDTO> inList = new ArrayList<>();

    @Override
    public void invoke(MoneyManagerDTO moneyManagerDTO, AnalysisContext analysisContext) {
        //时间格式转化
        String time = moneyManagerDTO.getTime();
        Date date = DateFormatUtils.StringToDate(time, "yyyy-MM-dd HH:mm:ss");
        time = DateFormatUtils.DateToString(date, "yyyy-MM-dd");
        //金额转为正数
        String amount = moneyManagerDTO.getCost();
        if (amount.startsWith("-")) {
            amount = amount.replace("-", "");
        }
        if (Objects.equals(moneyManagerDTO.getCostType(), "支出")) {
            YouQianOutDTO dto = new YouQianOutDTO();
            dto.setAccount("现金");
            dto.setMoneyType("人民币");
            dto.setContent(moneyManagerDTO.getContent());
            dto.setType(moneyManagerDTO.getType());
            dto.setReimbursement("不可报销");
            dto.setAmount(amount);
            dto.setTime(time);
            outList.add(dto);
        } else if (Objects.equals(moneyManagerDTO.getCostType(), "收入")) {
            YouQianDTO dto = new YouQianDTO();
            dto.setAccount("现金");
            dto.setMoneyType("人民币");
            dto.setContent(moneyManagerDTO.getContent());
            dto.setType(moneyManagerDTO.getType());
            dto.setAmount(amount);
            dto.setTime(time);
            inList.add(dto);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("所有数据解析完成！");

    }
}
