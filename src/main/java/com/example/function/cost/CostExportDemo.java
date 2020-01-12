package com.example.function.cost;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.ReadListener;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2020/1/12 10:32
 * @description: 记账数据表格转换
 */
public class CostExportDemo {

    private static final String basePath = "/Users/jianglingjun/Downloads/";
    private static final String sourcePath = basePath + "2019-08-01-2020-01-31.xlsx";
    private static final String srcOutPath = basePath + "youqian-out.xlsx";
    private static final String srcInPath = basePath + "youqian-in.xlsx";

    public static void main(String[] args) {
        EasyExcel.read(sourcePath, MoneyManagerDTO.class, new ExcelListener()).sheet().doRead();
        List<YouQianOutDTO> outList = ExcelListener.outList;
        List<YouQianDTO> inList = ExcelListener.inList;

        EasyExcel.write(srcOutPath, YouQianOutDTO.class)
                .sheet("支出")
                .doWrite(outList);

        EasyExcel.write(srcInPath, YouQianDTO.class)
                .sheet("收入")
                .doWrite(inList);



    }
}
